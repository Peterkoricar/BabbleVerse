package com.babbleverse.Message;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface MessageService {
    void sendMessage(@PathVariable String message);
}
