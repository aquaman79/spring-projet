package com.m2.tiila.weatherapi.repository;

import com.m2.tiila.weatherapi.repository.client.OpenWeeatherClient;
import dto.openweather_swagger.Model200;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeatherReposity {

    @Inject
    private OpenWeeatherClient openWeeatherClient;


    @Value("${spring.secrets.openweather.token}")
    private String token;

    @Inject
    private CityRepository cityRepository;

    public Model200 getCityWeather(String cityName) {
        return this.openWeeatherClient.getWeather(cityName, token);
    }
}
