package com.arun.events.producer.service;

import com.arun.events.producer.model.Event;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by arunnair on 07/11/2016.
 */
@Service
public interface IEventPollerService {

    List<Event> getEvents(File file) throws IOException;

}
