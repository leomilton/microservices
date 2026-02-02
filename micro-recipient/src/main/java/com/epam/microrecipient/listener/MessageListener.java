package com.epam.microrecipient.listener;

import com.epam.microrecipient.dto.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class MessageListener {

    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    private final List<NotificationRequest> messages = new CopyOnWriteArrayList<>();

    @RabbitListener(queues = "notification.queue")
    public void receive(NotificationRequest request) {
        messages.add(request);
        log.info("Received message: {}", request.getMessage());
    }

    public int size() {
        return messages.size();
    }

    public List<NotificationRequest> drain() {
        List<NotificationRequest> copy = new ArrayList<>(messages);
        messages.clear();
        return copy;
    }
}
