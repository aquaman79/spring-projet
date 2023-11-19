package com.m2.tiila.weatherapi.controller;


import com.m2.tiila.weatherapi.Buisness.CityBusness;
import com.m2.tiila.weatherapi.Buisness.WeatherBusiness;
import com.m2.tiila.weatherapi.filter.AuthentificationRequired;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.m2.tiila.weatherapi.mapper.CityMapper.cityToEntity;

@Controller
@Path("/previsions")
public class WeitherControlleur {

    @Inject
    private CityBusness cityBusness;

    @Inject
    private WeatherBusiness weatherBusiness;

    /*
    @Path("/{city}")
    @GET
    @Produces
    public Response previsions(@PathParam("city") String city){
        return Response.ok(WeatherBusiness.getCityWeather(city)).build();
    }
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{city}")
    public Response previsions(@PathParam("city") String city,@HeaderParam("user-agent")String user){

        return Response.ok(    weatherBusiness.getCityWeather(city,user)).build();
    }
}
