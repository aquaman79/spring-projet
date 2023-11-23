package com.m2.tiila.weatherapi.repository.client;


import dto.openweather_swagger.Model200;
import feign.Param;
import feign.RequestLine;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


public interface OpenWeeatherClient {
   // @Cacheable(value = "weather",key="#cityName")
    @RequestLine("GET /data/2.5/weather?q={cityName}&appid={token}&units=matric")
    Model200 getWeather(
            @Param("cityName") String cityName,
            @Param("token") String token
    );
}
