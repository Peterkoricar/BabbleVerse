package com.BabbleVerse.Message;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface MessageService {
    Message sendmessage(@PathVariable String message);
    void saveMessageSendTime(@PathVariable Message message);
}
