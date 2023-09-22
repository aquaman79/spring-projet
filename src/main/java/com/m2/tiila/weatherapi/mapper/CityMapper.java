package com.m2.tiila.weatherapi.mapper;

import com.m2.tiila.weatherapi.entity.CityEntity;
import dto.weather.City;
import org.springframework.beans.factory.annotation.Autowired;

public class CityMapper {

    public static City cityToDto(CityEntity cityEntity){
        City cityDto = new City();
        cityDto.setId(cityEntity.getId());
        cityDto.setName(cityEntity.getName());
        cityDto.setRegion(cityEntity.getRegion());
        cityDto.setCountry(cityEntity.getCountry());
        cityDto.setCodePostale(cityEntity.getCodePostale());
        return cityDto;
    }

    public static CityEntity cityToEntity(City city){
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCodePostale(city.getCodePostale());
        cityEntity.setName(city.getName());
        cityEntity.setCountry(city.getCountry());
        cityEntity.setId(city.getId());
        cityEntity.setRegion(city.getRegion());
        return cityEntity;
    }
}
