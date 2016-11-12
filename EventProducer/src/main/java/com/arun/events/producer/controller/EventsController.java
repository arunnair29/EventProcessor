package com.arun.events.producer.controller;

import com.arun.events.producer.model.Event;
import com.arun.events.producer.service.IEventExtractorService;
import com.arun.events.producer.service.IEventPublishService;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by arunnair on 06/11/2016.
 */
@Component("eventsController")
public class EventsController {
    @Autowired
    IEventExtractorService eventExtractorService;

    @Autowired
    IEventPublishService eventPublishService;

   public void processSource(Exchange exchange){
        File file = (File)exchange.getIn().getBody();
       try {
           BufferedReader reader = new BufferedReader(new FileReader(file));
          for(Event event: eventExtractorService.getEvents(reader)) {
                eventPublishService.publishEvent(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
