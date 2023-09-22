package com.m2.tiila.weatherapi.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/health")
public class HealthControlleur {

    @GET
    public Response getHealth(){
        return Response.ok("Yeah i'm fine ").build();
    }

}
