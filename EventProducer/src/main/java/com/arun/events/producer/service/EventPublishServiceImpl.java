package com.arun.events.producer.service;

import com.arun.events.producer.model.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by arunnair on 06/11/2016.
 */
@Service("eventPublishService")
public class EventPublishServiceImpl implements IEventPublishService{

    final static Logger LOG =Logger.getLogger(EventPublishServiceImpl.class);

    //destination queue for sending messages.
    private String JMS_QUEUE="events.queue";

    @Autowired
    JmsTemplate jmsTemplate;


    public void publishEvent(Event event) {
        LOG.info("Publishing event" + event);
        ObjectMapper mapper = new ObjectMapper();
        try {
            jmsTemplate.convertAndSend(JMS_QUEUE, mapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            LOG.error(e);
        }
    }
}
