package com.marcusvmleite.controller;

import com.marcusvmleite.model.Meetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class RsvpController {

    private ReactiveMongoTemplate template;

    @Autowired
    public RsvpController(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @GetMapping(value = "meetups", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux meetups() {
        return template.tail(new Query(), Meetup.class).share();
    }

}
