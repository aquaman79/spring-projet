package com.m2.tiila.weatherapi.Buisness;

import com.m2.tiila.weatherapi.repository.WeatherReposity;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

@Component

public class WeatherBusiness {


    @Inject
    static WeatherReposity weatherReposity;
    public static Object getCityWeather(String city){
        return weatherReposity.getCityWeather(city);
    }
}
