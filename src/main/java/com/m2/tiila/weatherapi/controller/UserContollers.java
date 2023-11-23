package com.m2.tiila.weatherapi.controller;

import com.m2.tiila.weatherapi.Buisness.UsersBuisness;
import com.m2.tiila.weatherapi.dto.User;
import com.m2.tiila.weatherapi.filter.AuthentificationRequired;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import static com.m2.tiila.weatherapi.mapper.CityMapper.cityToEntity;
import static com.m2.tiila.weatherapi.mapper.UserMapper.userToEntity;
@Controller
@Path("/users")
public class UserContollers {


    @Inject
    UsersBuisness usersBuisness;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthentificationRequired
    public Response createUser(User user){
        this.usersBuisness.createUser(userToEntity(user));
        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<User> getUser(@QueryParam("id") String id){
        return new ResponseEntity<>( this.usersBuisness.find(id), HttpStatus.OK);

    }


}
