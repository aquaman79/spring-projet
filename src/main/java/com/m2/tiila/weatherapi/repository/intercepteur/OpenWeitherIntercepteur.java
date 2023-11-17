package com.m2.tiila.weatherapi.repository.intercepteur;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OpenWeitherIntercepteur implements RequestInterceptor {
    //appliquer une interception
    @Override
    public void apply(RequestTemplate template) {
        template.header("from","weather-api");
        log.info(" ################ 123 going to weather api ");
    }
}
