package com.arun.events.consumer.service;

import com.arun.events.consumer.entity.Event;
import com.arun.events.consumer.repository.IEventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by arunnair on 07/11/2016.
 *
 * This is the service class
 */
@Component
public class EventConsumerService implements IEventConsumerService {

    @Autowired
    IEventRepository IEventRepository;

    @Autowired
    ObjectMapper mapper;

    final static Logger LOG =Logger.getLogger(EventConsumerService.class);
    private final String JMS_QUEUE="events.queue";

    @JmsListener(destination = JMS_QUEUE)
    public void processMessage(String message) {
        if(null==message){
            LOG.warn("NULL message received");
            return;
        }
        Event event=null;
        try {

            event = mapper.readValue(message, Event.class);
            event = IEventRepository.save(event);

        } catch (IOException e) {
            LOG.error(e);
        }

        LOG.info("Inserted an event : event.Id: " + event.getId() );
    }

}

