package io.vstream.apiserver.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/test")
public class TestEndpoint {

    @GET
    @Path("echo")
    public String message() {
        return "Hello";
    }

}
