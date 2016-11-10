package com.arun.events.producer.service;

import com.arun.events.producer.model.Event;
import com.arun.events.producer.model.Events;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.apache.camel.Body;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.FacebookAutoConfiguration;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arunnair on 07/11/2016.
 */
@Component("eventPoller")
public class EventPollerServiceImpl implements IEventPollerService {

    final static Logger LOG =Logger.getLogger(EventPollerServiceImpl.class);


    @Override
    public List<Event> getEvents(File file) throws IOException {

        JsonReader reader = new JsonReader(new InputStreamReader(
                new FileInputStream(file),"UTF-8"));
        reader.setLenient(true);
        Gson gson = new GsonBuilder().create();

        List<Events> eventsList=new ArrayList<Events>();
        while (reader.hasNext()) {
            if (reader.peek().toString().matches("END_DOCUMENT")) {
                break;
            }
            Events events = gson.fromJson(reader, Events.class);
             LOG.info("Adding event " + events.toString());
            eventsList.add(events);

        }
        reader.close();
        List<Event> eventList=new ArrayList<Event>();
        for(Events events: eventsList){
            eventList.addAll(events.getEvents());
        }
        return eventList;

    }

}
