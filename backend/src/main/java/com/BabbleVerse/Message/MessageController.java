package com.BabbleVerse.Message;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MessageController {
    MessageService messageService;
    public MessageController(MessageService messageService){

        this.messageService=messageService;
    }

}
