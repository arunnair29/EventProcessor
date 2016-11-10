package com.arun.events.consumer.repository;

import com.arun.events.consumer.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by arunnair on 10/11/2016.
 */
public interface IEventRepository extends MongoRepository<Event, String> {

}
