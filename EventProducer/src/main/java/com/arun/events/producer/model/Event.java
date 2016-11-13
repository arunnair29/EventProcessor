package com.arun.events.producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by arunnair on 06/11/2016.
 */
@Component
public class Event implements Serializable{

    @SerializedName("attributes")
    private Attributes attributes;


    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }



}
