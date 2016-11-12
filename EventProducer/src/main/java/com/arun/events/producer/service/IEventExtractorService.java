package com.arun.events.producer.service;

import com.arun.events.producer.model.Event;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by arunnair on 07/11/2016.
 */
public interface IEventExtractorService {

    List<Event> getEvents(BufferedReader reader) throws IOException;

}
