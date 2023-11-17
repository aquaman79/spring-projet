package com.m2.tiila.weatherapi.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2.tiila.weatherapi.repository.client.OpenWeeatherClient;
import com.m2.tiila.weatherapi.repository.intercepteur.OpenWeitherIntercepteur;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import jakarta.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    @Inject
    private ObjectMapper objectMapper;
    @Inject
    private OpenWeitherIntercepteur intercepteur;
    @Bean
    public OpenWeeatherClient getOpenWeatherClient(){
       return  Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .encoder(new JacksonEncoder(objectMapper))
                .client(new OkHttpClient(getOkHttpClient()))
               .requestInterceptor(intercepteur)
               .logger(new Logger.JavaLogger(FeignConfig.class))
               .logLevel(Logger.Level.FULL)
                .target(OpenWeeatherClient.class,"https://api.openweathermap.org/");
    }

    private okhttp3.OkHttpClient getOkHttpClient(){
        var okhttpClient = new okhttp3.OkHttpClient().newBuilder();
        okhttpClient.connectTimeout(1000, TimeUnit.MILLISECONDS);
        okhttpClient.readTimeout(1000, TimeUnit.MILLISECONDS);
        return okhttpClient.build();
    }
}
