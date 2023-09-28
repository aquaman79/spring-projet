package com.m2.tiila.weatherapi.controller;


import com.m2.tiila.weatherapi.Buisness.CityBusness;
import dto.weather.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

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


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCity(@PathParam("id") String id, City city){
        this.cityBusness.updateCity(id,cityToEntity(city));
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCity(@PathParam("id") String id){
        this.cityBusness.deleteCity(id);
        return Response.ok().build();
    }
}
