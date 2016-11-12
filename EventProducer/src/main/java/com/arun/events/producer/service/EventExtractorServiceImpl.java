package com.arun.events.producer.service;

import com.arun.events.producer.model.Event;
import com.arun.events.producer.model.Events;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arunnair on 07/11/2016.
 */
@Service("eventExtractorService")
public class EventExtractorServiceImpl implements IEventExtractorService {

   final static Logger LOG =Logger.getLogger(EventExtractorServiceImpl.class);

    /**
     *
     * @param bufferedReader File object holding list of events
     * @return
     * @throws IOException
     */
    public List<Event> getEvents(BufferedReader bufferedReader) throws IOException {

        JsonReader reader = new JsonReader(bufferedReader);
        reader.setLenient(true);
        Gson gson = new GsonBuilder().create();

        List<Events> eventsList=new ArrayList<Events>();
        try {
            while (reader.hasNext()) {
                if (reader.peek().toString().matches("END_DOCUMENT")) {
                    break;
                }
                Events events = gson.fromJson(reader, Events.class);
                 LOG.info("Adding extracted event " + events.toString());
                eventsList.add(events);

            }
        } catch (IOException e) {
            LOG.error("Error reading File ");
            LOG.error(e);
        } catch (JsonIOException e) {
            LOG.error("Error reading File ");
            LOG.error(e);
        } catch (JsonSyntaxException e) {
            LOG.error("Invalid Source File , Check file format ");
            LOG.error(e);
        } finally {
            reader.close();
        }
        List<Event> eventList=new ArrayList<Event>();
        //Extract EventList from Events class and add to master Event List
        for(Events events: eventsList){

            eventList.addAll(events.getEvents());
        }
        return eventList;

    }

}
