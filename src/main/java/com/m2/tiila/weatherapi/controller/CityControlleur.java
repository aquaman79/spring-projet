package com.m2.tiila.weatherapi.controller;


import com.m2.tiila.weatherapi.Buisness.CityBusness;
import dto.weather.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import static com.m2.tiila.weatherapi.mapper.CityMapper.cityToEntity;

@Controller
@Path("/citys")
public class CityControlleur {

    @Inject
    private CityBusness cityBusness;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCity(City city){
        this.cityBusness.createCity(cityToEntity(city));
        return Response.ok().build();
    }
}
