package com.babbleverse.message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    /*MessageService messageService;
    public MessageController(MessageService messageService){

        this.messageService=messageService;
    }
    public MessageController(){

    }
*/
    private MessageService serv;

    public MessageController(MessageService serv) {
        this.serv = serv;
    }

    @MessageMapping("/send/message")
    public void sendMessage(String message){
        serv.sendMessage(message);
    }
}

