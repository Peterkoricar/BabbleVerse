import { Component, OnInit } from '@angular/core';
import { WebSocketAPI } from '../WebSocketAPI';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  webSocketAPI!: WebSocketAPI;
  greeting: any;
  name!: string;
  ngOnInit() {
    this.webSocketAPI = new WebSocketAPI(new HomepageComponent());

  }

  connect(){
    this.webSocketAPI._connect();
  }

  disconnect(){
    this.webSocketAPI._disconnect();
  }

  sendMessage(){
    this.webSocketAPI._send(this.name);
  }

  handleMessage(message: any){
    this.greeting = message;
  }

}
