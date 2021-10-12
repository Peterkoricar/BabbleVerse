package com.BabbleVerse.Message;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
@Service
public interface MessageService {
    Message sendmessage(String message);
    void saveMessage(@NotNull Message message);
}
