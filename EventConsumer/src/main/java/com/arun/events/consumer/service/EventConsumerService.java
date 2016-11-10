package com.arun.events.consumer.service;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by arunnair on 07/11/2016.
 */
@Component
public class EventConsumerService {

    final static Logger LOG =Logger.getLogger(EventConsumerService.class);
    private final String JMS_QUEUE="events.queue";
           @JmsListener(destination = JMS_QUEUE)
           public void processMessage(String message) {
           LOG.info(message);
        }

}

