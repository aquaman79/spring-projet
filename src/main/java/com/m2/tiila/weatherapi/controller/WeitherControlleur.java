package com.m2.tiila.weatherapi.controller;


import com.m2.tiila.weatherapi.Buisness.WeatherBusiness;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/previsions")
public class WeitherControlleur {
    @Path("/{city}")
    @GET
    @Produces
    public Response previsions(@PathParam("city") String city){
        return Response.ok(WeatherBusiness.getCityWeather(city)).build();
    }

}
