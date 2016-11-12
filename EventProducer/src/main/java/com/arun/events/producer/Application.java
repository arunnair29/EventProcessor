package com.arun.events.producer;

import com.arun.events.producer.controller.EventsController;
import org.apache.activemq.broker.BrokerService;
import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Application Class for Springboot.
 *
 */
@SpringBootApplication
@EnableJms
@ImportResource("classpath:broker-config.xml")
public class Application {

    public static void main( String[] args ) {
        ConfigurableApplicationContext applicationContext = SpringApplication
                .run(Application.class, args);
    }

}
