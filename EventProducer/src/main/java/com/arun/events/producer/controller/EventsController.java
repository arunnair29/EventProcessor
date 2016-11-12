package com.arun.events.producer.controller;

import com.arun.events.producer.model.Event;
import com.arun.events.producer.service.IEventPollerService;
import com.arun.events.producer.service.IEventPublishService;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Created by arunnair on 06/11/2016.
 */
@Component("eventsController")
public class EventsController {
    @Autowired
    IEventPollerService eventPollerService;

    @Autowired
    IEventPublishService eventPublishService;

   public void processSource(Exchange exchange){
        File file = (File)exchange.getIn().getBody();
        try {
            for(Event event:eventPollerService.getEvents(file)) {
                eventPublishService.publishEvent(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
