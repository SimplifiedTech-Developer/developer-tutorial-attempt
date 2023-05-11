package za.co.simplifiedtech.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BasicRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .routeId("TestRoute")
                .log("Received message: ${body}")
                .to("mock:result");
    }
}
