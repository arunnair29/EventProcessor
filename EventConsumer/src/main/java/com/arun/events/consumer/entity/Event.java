package com.arun.events.consumer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * Created by arunnair on 06/11/2016.
 * This is the Document object for Event . This will be added to events collection in database
 *
 */
@Component
@Document(collection = "events")
public class Event {



    @Id
    String id;

    private Attributes attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }



}
