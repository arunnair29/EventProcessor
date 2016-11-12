package com.arun.events.consumer.repository;

import com.arun.events.consumer.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by arunnair on 10/11/2016.
 * This interface makes use of MongoRepository. Springboot will manage instantiation
 * and we can use standard save and find methods in the MongoRepository interface.
 */
public interface IEventRepository extends MongoRepository<Event, String> {

}
