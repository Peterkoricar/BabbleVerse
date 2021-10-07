package com.BabbleVerse.Message;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {
MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }
    public void saveMessageSendTime(Message message,String messageSendTime){
        messageSendTime = message.getMessageSendTime();
        messageRepository.save(message.);
    }
}
