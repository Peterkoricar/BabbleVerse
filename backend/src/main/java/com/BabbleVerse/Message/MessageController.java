package com.BabbleVerse.Message;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    MessageService messageService;
    public MessageController(MessageService messageService){

        this.messageService=messageService;
    }

    @PostMapping("/test")
    public void saveMessage(@RequestBody Message message){
    messageService.saveMessage(message);
    }
}
