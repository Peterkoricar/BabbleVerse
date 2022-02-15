package com.babbleverse.message;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    MessageRepository messageRepository;
    private final SimpMessagingTemplate template;



    public MessageServiceImpl(MessageRepository messageRepository, SimpMessagingTemplate template){
        this.messageRepository=messageRepository;
        this.template = template;
    }

    @Override
    public void sendMessage(String message) {
        this.template.convertAndSend("/message",  message);
    }
}
