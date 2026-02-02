package com.epam.microcollector.scheduler;

import com.epam.microcollector.dto.NotificationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CollectorScheduler {

    private static final Logger log = LoggerFactory.getLogger(CollectorScheduler.class);

    private final RestTemplate restTemplate;
    private final String recipientBaseUrl;

    public CollectorScheduler(RestTemplate restTemplate,
                              @Value("${recipient.base-url}") String recipientBaseUrl) {
        this.restTemplate = restTemplate;
        this.recipientBaseUrl = recipientBaseUrl;
    }

    @Scheduled(fixedRate = 10000) // M = 10 seconds ( > N )
    public void collectMessages() {

        log.info("CollectorScheduler started");

        NotificationMessage[] response =
                restTemplate.getForObject(recipientBaseUrl  + "/message", NotificationMessage[].class);

        if (response == null || response.length == 0) {
            log.info("No messages received from micro-recipient");
            return;
        }

        List<NotificationMessage> messages = Arrays.asList(response);

        messages.forEach(msg ->
                log.info("Collected message from {} : {}", msg.getUser(), msg.getMessage())
        );
    }
}
