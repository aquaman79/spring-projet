package com.m2.tiila.weatherapi.repository;


import dto.weather.City;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CityRepository {
    private final static String SQL_INSERT_CITY = "INSERT INTO CITYS (ID,NAME,REGION,COUNTRY,CODEPOSTAL) VALUES(:id,:name,:region,:country,:codepostal) ";

    @Inject // je veux que tu injecte tous les config de la bdd ici
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
    public void createCity(City city){
        //preparer les parametres
        var params = new HashMap<String,String>();
        params.put("id",city.getId());
        params.put("name",city.getName());
        params.put("region",city.getRegion());
        params.put("country",city.getCountry());
        params.put("codepostal",city.getCodePostale());

        this.namedParameterJdbcTemplate.update(SQL_INSERT_CITY,params);
    }
}
