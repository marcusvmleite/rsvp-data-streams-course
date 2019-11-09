package com.marcusvmleite.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;

@Component
@EnableBinding(Source.class)
public class RsvpKafkaProducer {

    private Source source;

    @Autowired
    public RsvpKafkaProducer(Source source) {
        this.source = source;
    }

    public void send(WebSocketMessage<?> message) {
        source.output().send(MessageBuilder.withPayload(message.getPayload()).build(), 10000);
    }

}
