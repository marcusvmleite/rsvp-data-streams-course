package com.marcusvmleite.websocket;

import com.marcusvmleite.kafka.RsvpKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class RsvpWebSocketHandler extends AbstractWebSocketHandler {

    private RsvpKafkaProducer producer;

    @Autowired
    public RsvpWebSocketHandler(RsvpKafkaProducer producer) {
        this.producer = producer;
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        producer.send(message);
    }

}
