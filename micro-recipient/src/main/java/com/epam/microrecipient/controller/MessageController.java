package com.epam.microrecipient.controller;

import com.epam.microrecipient.dto.NotificationRequest;
import com.epam.microrecipient.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private final MessageListener listener;

    public MessageController(MessageListener listener) {
        this.listener = listener;
    }

    @GetMapping("/message")
    public List<NotificationRequest> getMessages() {
        log.info("GET /message called");
        return listener.drain();
    }
}

