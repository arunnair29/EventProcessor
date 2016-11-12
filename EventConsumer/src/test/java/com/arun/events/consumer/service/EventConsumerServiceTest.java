package com.arun.events.consumer.service;

import com.arun.events.consumer.repository.IEventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by arunnair on 12/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EventConsumerServiceTest {

    @Mock
    private IEventRepository mockRepository;

    @Mock
    private ObjectMapper mapper=new ObjectMapper();

    @Autowired
    @InjectMocks
    EventConsumerService consumerService;


    /**
     * This test proves that application handles null message from queue gracefully;
     */
    @Test
    public void procesNullMessage(){

        String message =null;
        consumerService.processMessage(message);
        assert(true);

    }

    }
