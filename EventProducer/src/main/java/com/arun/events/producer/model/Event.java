package com.arun.events.producer.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by arunnair on 06/11/2016.
 */
@Component
public class Event implements Serializable{

    private Attributes attributes;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }



}
