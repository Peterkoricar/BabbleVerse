import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { HomepageComponent } from './homepage/homepage.component';

export class WebSocketAPI {
    webSocketEndPoint: string = 'http://localhost:8080/ws';
    topic: string = "/topic/greetings";
    stompClient: any;
    homepageComponent: HomepageComponent;
    constructor(homepageComponent: HomepageComponent){
        this.homepageComponent = homepageComponent;
    }
    _connect() {
        console.log("Initialize WebSocket Connection");
        let ws = new SockJS(this.webSocketEndPoint);
        this.stompClient = Stomp.over(ws);
        const _this = this;
        _this.stompClient.connect({}, function (frame: any) {
            _this.stompClient.subscribe(_this.topic, function (sdkEvent: any) {
                _this.onMessageReceived(sdkEvent);
            });
        }, this.errorCallBack);
    };

    _disconnect() {
        if (this.stompClient !== null) {
            this.stompClient.disconnect();
        }
        console.log("Disconnected");
    }

    errorCallBack(error: string) {
        console.log("errorCallBack -> " + error)
        setTimeout(() => {
            this._connect();
        }, 5000);
    }

 /** 
  * @param {*} message 
  */
    _send(message: string) {
        console.log("calling logout api via web socket");
        this.stompClient.send("/app/hello", {}, JSON.stringify(message));
    }

    onMessageReceived(message: string) {
        console.log("Message Recieved from Server :: " + message);
        this.homepageComponent.handleMessage(JSON.stringify(message)); //message.body
    }
}