package com.marcusvmleite;

import com.marcusvmleite.websocket.RsvpWebSocketHandler;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner initialize(RsvpWebSocketHandler handler) {
        return args -> {

            WebSocketClient client = new StandardWebSocketClient();
            client.doHandshake(handler, "ws://stream.meetup.com/2/rsvps");
        };
    }


}
