package za.co.simplifiedtech.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        errorHandler(defaultErrorHandler().maximumRedeliveries(3));

        from("file:input?delete=true")
                .routeId("FileRoute")
                .log("Received file: ${file:name}")
                .choice()
                .when(header("CamelFileName").endsWith(".xml"))
                .to("direct:xmlProcessing")
                .when(header("CamelFileName").endsWith(".csv"))
                .to("direct:csvProcessing")
                .otherwise()
                .log("Unsupported file type")
                .to("mock:unsupported")
                .end();

        from("direct:xmlProcessing")
                .routeId("XmlProcessingRoute")
                .log("Processing XML file: ${file:name}")
                .to("mock:xmlProcessingResult");

        from("direct:csvProcessing")
                .routeId("CsvProcessingRoute")
                .log("Processing CSV file: ${file:name}")
                .to("mock:csvProcessingResult");

        // Other routes and configurations...

        // Integration with external systems
        from("direct:sendToExternal")
                .routeId("ExternalSystemRoute")
                .log("Sending message to external system: ${body}")
                //.to("http://external-system-api.com")
                .log("Response from external system: ${body}");

        // Testing
        from("direct:start")
                .routeId("TestRoute")
                .log("Received message: ${body}")
                .to("mock:result");
    }
}