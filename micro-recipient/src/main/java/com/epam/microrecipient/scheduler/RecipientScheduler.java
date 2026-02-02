package com.epam.microrecipient.scheduler;

import com.epam.microrecipient.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RecipientScheduler {

    private static final Logger log = LoggerFactory.getLogger(RecipientScheduler.class);

    private final MessageListener listener;

    public RecipientScheduler(MessageListener listener) {
        this.listener = listener;
    }

    @Scheduled(fixedRate = 5000) // N = 5 seconds
    public void logMessages() {
        log.info("Scheduler running. Stored messages count: {}", listener.size());
    }
}
