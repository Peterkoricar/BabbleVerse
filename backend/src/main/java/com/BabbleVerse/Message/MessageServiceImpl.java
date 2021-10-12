package com.BabbleVerse.Message;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService{
MessageRepository messageRepository;
Message message;

    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    @Override
    public Message sendmessage(String message) {
        return null;
    }

    public void saveMessage(Message message){
        Date date = new Date();
        message.setSendTime(date);
        messageRepository.save(message);
    }
}
