package com.arun.events.producer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by arunnair on 12/11/2016.
 */
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void validateContext(){
        assertThat(this.context).isNotNull();
    }
}
