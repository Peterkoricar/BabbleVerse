package com.BabbleVerse.Message;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl {
MessageRepository messageRepository;
Message message;

    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    public void saveMessageSendTime(Message message){
        Date date = new Date();
        message.setSendTime(date.toString());
    }
}
