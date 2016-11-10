package com.arun.events.producer.service;

import com.arun.events.producer.model.Event;

/**
 * Created by arunnair on 06/11/2016.
 */
public interface IEventPublishService {

 void publishEvent(Event event);
}
