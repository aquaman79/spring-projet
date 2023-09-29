package com.m2.tiila.weatherapi.controller;


import com.m2.tiila.weatherapi.Buisness.CityBusness;
import com.m2.tiila.weatherapi.filter.AuthentificationRequired;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import static com.m2.tiila.weatherapi.mapper.CityMapper.cityToEntity;

@Controller
@Path("/citys")
public class CityControlleur {


    //spring doit aller chercher une classe s'appelle citybuesneess et doit l'injecter
    @Inject
    private CityBusness cityBusness;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthentificationRequired
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

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<City>> getAll(){
        return new ResponseEntity<>( this.cityBusness.getAll(), HttpStatus.OK);
    }

//    @GET
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ResponseEntity<City> getCity(@PathParam("id") String id){
//        return new ResponseEntity<>(this.cityBusness.getCity(id),HttpStatus.OK);
//    }

}
