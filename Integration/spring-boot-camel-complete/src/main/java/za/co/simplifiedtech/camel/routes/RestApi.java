package za.co.simplifiedtech.camel.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.simplifiedtech.camel.service.MyService;
import za.co.simplifiedtech.camel.dto.request.UserDTO;

import javax.ws.rs.core.MediaType;

@Component
public class RestApi extends RouteBuilder {
    @Value("${server.port}")
    String serverPort;

    @Value("${endpoint.api.path}")
    String contextPath;

    @Override
    public void configure() {
        CamelContext context = new DefaultCamelContext();
        // http://localhost:8080/camel/api-doc
        restConfiguration().contextPath(contextPath) //
                .port(serverPort)
                .enableCORS(true)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Test REST API")
                .apiProperty("api.version", "v1")
                .apiProperty("cors", "true") // cross-site
                .apiContextRouteId("doc-api")
                .component("servlet")
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true");

        /**
         The Rest DSL supports automatic binding json/xml contents to/from
         POJOs using Camels Data Format.
         By default, the binding mode is off, meaning there is no automatic
         binding happening for incoming and outgoing messages.
         You may want to use binding if you develop POJOs that maps to
         your REST services request and response types.
         */
        rest("/api/")
                .description("Test REST Service")
                .id("api-route")
                .post("/bean")
                .produces(MediaType.APPLICATION_JSON)
                .consumes(MediaType.APPLICATION_JSON)
                // .get("/hello/{place}")
                .bindingMode(RestBindingMode.auto)
                .type(UserDTO.class)
                .enableCORS(true)
                // .outType(OutBean.class)
                /*The following line routes the message to the 'remoteService' endpoint using the 'direct' component.
                   This means the message will be sent directly to another part of the Camel route within the same JVM.
                   The 'direct' component provides synchronous communication within the Camel application.
                    It is useful for internal routing without involving external systems or protocols.
                    The message will be processed by the 'remoteService' route or processor.
                    */
                .to("direct:remoteService");

        from("direct:remoteService")
                .routeId("direct-route")
                .tracing()
                .log("ID : ${body.id}")
                .log("Name : ${body.name}")
                // .transform().simple("blue ${in.body.name}")
                .process(exchange -> {
                    UserDTO userDTOBodyIn = (UserDTO) exchange.getIn()
                                                .getBody();

                    MyService.example(userDTOBodyIn);

                    exchange.getIn()
                            .setBody(userDTOBodyIn);
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
    }
}
