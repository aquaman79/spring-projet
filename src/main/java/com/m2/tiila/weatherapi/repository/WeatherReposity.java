package com.m2.tiila.weatherapi.repository;

import com.m2.tiila.weatherapi.repository.client.OpenWeeatherClient;
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
    CityRepository cityRepository;

    public Object getCityWeather(String cityName) {

        List<City> citys = cityRepository.getAll();
        if(citys.contains(cityName)){
            return this.openWeeatherClient.getWeather(cityName, token);

        }

        return this.openWeeatherClient.getWeather(cityName, token);
    }
}
