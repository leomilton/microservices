package com.epam.microrecipient.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitListenerConfig {

    @Bean
    public Jackson2JsonMessageConverter convertor() {
        return new Jackson2JsonMessageConverter();
    }
}
