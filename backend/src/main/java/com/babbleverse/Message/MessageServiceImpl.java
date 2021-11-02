package com.babbleverse.Message;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {
MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }
}
