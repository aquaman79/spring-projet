package com.m2.tiila.weatherapi.mapper;

import com.m2.tiila.weatherapi.entity.CityEntity;
import dto.weather.City;
import org.springframework.beans.factory.annotation.Autowired;

public class CityMapper {

    public static City cityToDto(CityEntity cityEntity){
        City cityDto = new City();
        cityDto.setId(cityEntity.getId());
        cityDto.setNomVille(cityEntity.getName());
        cityDto.setRegion(cityEntity.getRegion());
        cityDto.setCountry(cityEntity.getCountry());
        cityDto.setPosteCode(cityEntity.getCodepostale());
        return cityDto;
    }

    public static CityEntity cityToEntity(City city){
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCodepostale(city.getPosteCode());
        cityEntity.setName(city.getNomVille());
        cityEntity.setCountry(city.getCountry());
        cityEntity.setId(city.getId());
        cityEntity.setRegion(city.getRegion());
        return cityEntity;
    }
}
