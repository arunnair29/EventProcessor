package com.arun.events.producer.service;

import com.arun.events.producer.model.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by arunnair on 12/11/2016.
 */
@RunWith(SpringRunner.class)
public class EventExtractorServiceImplTest {


    @Test()
    public void fileExtractorForValidEvents() {
        String data = "{\"events\":[{\"attributes\":{\"name\":\"Arun\",\"transactionAmount\":\"250.00 USD\",\"product\":\"Platinum\",\"accountNumber\":\"3717000000000\"}}]}{\"events\":[{\"attributes\":{\"name\":\"Joe\",\"transactionAmount\":\"350.00 USD\",\"product\":\"Green\",\"accountNumber\":\"3717000000001\"}}]}{\"events\":[{\"attributes\":{\"name\":\"Joe\",\"transactionAmount\":\"350.00 USD\",\"product\":\"Green\",\"accountNumber\":\"3717000000001\"}}]}";
        BufferedReader reader = new BufferedReader(new StringReader(data));
        List<Event> eventsList=null;
        try {
            eventsList = new EventExtractorServiceImpl().getEvents(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert(eventsList.size()==3);
    }

    @Test()
    public void fileExtractorForInvalidValidEvents() {
        String data = "{\"attributes\":{\"name\":\"Arun\",\"transactionAmount\":\"250.00 USD\",\"product\":\"Platinum\",\"accountNumber\":\"3717000000000\"}";
        BufferedReader reader = new BufferedReader(new StringReader(data));
        List<Event> eventsList=null;
        try {
            eventsList = new EventExtractorServiceImpl().getEvents(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(eventsList.size()==0).isTrue();

    }
}
