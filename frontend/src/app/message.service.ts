import { Injectable } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { HomepageComponent } from './homepage/homepage.component';
@Injectable({
    providedIn: 'root'
  })
export class MessageService {
        
    constructor() {
        this.initializeWebSocketConnection();
      }
      public stompClient!: Stomp.Client;
      public msg: string[] = [];
      initializeWebSocketConnection() {
        const serverUrl = 'http://localhost:8080/socket';
        const ws = new SockJS(serverUrl);
        this.stompClient = Stomp.over(ws);
        const that = this;
        // tslint:disable-next-line:only-arrow-functions
        this.stompClient.connect({}, function(frame) {
          that.stompClient.subscribe('/message', (message) => {
            if (message.body) {
              that.msg.push(message.body);
            }
            
          });
        });
      }
      
      sendMessage(message: string | undefined) {
        this.stompClient.send('/app/send/message' , {}, message);
      }
    }