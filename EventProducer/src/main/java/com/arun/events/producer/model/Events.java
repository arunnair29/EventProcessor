package com.arun.events.producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by arunnair on 07/11/2016.
 */
public class Events {

    @JsonProperty("events")
    private List<Event> events;

    @JsonProperty("events")
    public List<Event> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEventsList(List<Event> events) {
        this.events = events;
    }



}
