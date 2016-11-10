package com.arun.events.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * Event Consumer Application Springboot
 *
 */
@SpringBootApplication
@EnableJms
public class Application
{

    public static void main( String[] args )
    {

        SpringApplication.run(Application.class,args);

    }
}
