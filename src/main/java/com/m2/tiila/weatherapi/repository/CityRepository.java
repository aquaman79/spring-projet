package com.m2.tiila.weatherapi.repository;


import dto.weather.City;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CityRepository {
    private final static String SQL_INSERT_CITY = "INSERT INTO CITYS (ID,NAME,REGION,COUNTRY,CODEPOSTAL) VALUES(:id,:name,:region,:country,:codepostal) ";
    private final static String SQL_UPDATE_CITY = " UPDATE CITYS SET NAME= :name, REGION= :region, COUNTRY= :country, CODEPOSTAL= :codepostal WHERE ID= :id";
    private final static String SQL_DELETE_CITY = " DELETE FROM CITYS WHERE ID= :id ";
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

    public void updateCity(String id , City city){
        //preparer les parametres
        var params = new HashMap<String,String>();
        params.put("id",id);
        params.put("name",city.getName());
        params.put("region",city.getRegion());
        params.put("country",city.getCountry());
        params.put("codepostal",city.getCodePostale());
        this.namedParameterJdbcTemplate.update(SQL_UPDATE_CITY,params);
    }

    public void deleteCity(String id ){
        var params = new HashMap<String,String>();
        params.put("id",id);
        this.namedParameterJdbcTemplate.update(SQL_DELETE_CITY,params);
    }
}
