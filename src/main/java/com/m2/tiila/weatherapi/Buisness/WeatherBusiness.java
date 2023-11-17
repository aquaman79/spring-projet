package com.m2.tiila.weatherapi.Buisness;

import com.m2.tiila.weatherapi.entity.PrevisionEntity;
import com.m2.tiila.weatherapi.repository.CityRepository;
import com.m2.tiila.weatherapi.repository.WeatherReposity;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class WeatherBusiness {


    @Inject
    static WeatherReposity weatherReposity;

    @Inject
    static CityRepository cityRepository;

    public static Object getCityWeather(String city,String user) {
        List<City> cities = cityRepository.getAll();
        if(user!=null || cities.contains(city)){
            return weatherReposity.getCityWeather(city);
        }
        return null;
    }




}