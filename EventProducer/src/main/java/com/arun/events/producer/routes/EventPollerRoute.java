package com.arun.events.producer.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.OnExceptionRouteNode;
import org.apache.camel.model.OnExceptionDefinition;
import org.springframework.stereotype.Component;

/**
 * Created by arunnair on 09/11/2016.
 * This class reads files from (file.path) directory and passes it to controller.
 * This is written using Camel Route
 */
@Component("eventPollerRoute")
public class EventPollerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://{{file.path}}")
                .log("file detected :${file:name}")
                .convertBodyTo(java.io.File.class,"UTF-8")
                .bean("eventsController","processSource")
                .onException(Exception.class).handled(true).to("file://{{file.path}}")
                .to("log:done");

    }
}
