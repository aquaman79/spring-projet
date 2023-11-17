package com.m2.tiila.weatherapi.repository;

import com.m2.tiila.weatherapi.repository.client.OpenWeeatherClient;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherReposity {

    @Inject
    private OpenWeeatherClient openWeeatherClient;


    @Value("${spring.secrets.openweather.token}")
    private String token;

    public Object getCityWeather(String cityName) {
        return this.openWeeatherClient.getWeather(cityName, token);
    }
}
