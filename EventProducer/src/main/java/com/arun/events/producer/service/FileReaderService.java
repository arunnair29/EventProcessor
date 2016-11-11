package com.arun.events.producer.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by arunnair on 09/11/2016.
 */
@Component("fileReaderService")
public class FileReaderService extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://{{file.path}}")
                .log("file detected :${file:name}")
                .convertBodyTo(java.io.File.class,"UTF-8")
                .bean("eventsController","processSource")
                .to("log:done");

    }
}
