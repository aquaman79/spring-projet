package com.m2.tiila.weatherapi.configuration;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/v1")
public class JerseyConfig extends ResourceConfig {

    //spring doit instancier tous les beans qui sont dans ce controller
    public JerseyConfig(){
        packages("com.m2.tiila.weatherapi.controller");
        packages("com/m2/tiila/weatherapi/filter");
        packages("com/m2/tiila/weatherapi/exception");

    }

}
