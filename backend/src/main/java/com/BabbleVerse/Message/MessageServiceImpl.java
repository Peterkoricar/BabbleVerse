package com.BabbleVerse.Message;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl {
MessageRepository messageRepository;
Message message;

    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }
    public void saveMessage(Message message){
        Date date = new Date();
        message.setSendTime(date.toString());
        messageRepository.save(message);
    }
}
