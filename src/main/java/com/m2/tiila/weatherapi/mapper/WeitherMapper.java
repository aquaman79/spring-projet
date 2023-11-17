package com.m2.tiila.weatherapi.mapper;

import com.m2.tiila.weatherapi.entity.PrevisionEntity;
import dto.weatherapi.Prevision;
import dto.weatherapi.WeatherState;

import java.time.Instant;
import java.time.LocalDate;

public class WeitherMapper {
    public static Prevision toDto(PrevisionEntity entity){
        Prevision prevision = new Prevision();

        prevision.setDate(LocalDate.from(entity.getDate()));
        prevision.setTemperature((int) entity.getTemperature());
        prevision.setCity(entity.getCity());
        prevision.setState(mapToExternal(WeatherState.valueOf(entity.getState())));

        return prevision;
    }
    public static dto.weatherapi.WeatherState mapToExternal(WeatherState internalWeatherState) {
        switch (internalWeatherState) {
            case NUAGEUX:
                return dto.weatherapi.WeatherState.NUAGEUX;
            case PLUVIEUX:
                return dto.weatherapi.WeatherState.PLUVIEUX;
            case NEIGEUX:
                return dto.weatherapi.WeatherState.NEIGEUX;
            case VENTEUX:
                return dto.weatherapi.WeatherState.VENTEUX;
            case ENSOLEILLE:
                return dto.weatherapi.WeatherState.ENSOLEILLE;
            default:
                throw new IllegalArgumentException("Conversion non gérée pour WeatherState: " + internalWeatherState);
        }
    }
}

