package com.m2.tiila.weatherapi.Buisness;


import com.m2.tiila.weatherapi.entity.CityEntity;
import com.m2.tiila.weatherapi.mapper.CityMapper;
import com.m2.tiila.weatherapi.repository.CityRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import static com.m2.tiila.weatherapi.mapper.CityMapper.cityToDto;

@Component
public class CityBusness {

    @Inject
    private CityRepository cityRepository;


    public void createCity(CityEntity cityEntity){
        this.cityRepository.createCity(cityToDto(cityEntity));
    }
}
