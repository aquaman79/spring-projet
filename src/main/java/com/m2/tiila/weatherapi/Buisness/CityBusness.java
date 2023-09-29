package com.m2.tiila.weatherapi.Buisness;


import com.m2.tiila.weatherapi.entity.CityEntity;
import com.m2.tiila.weatherapi.exception.FunctionalException;
import com.m2.tiila.weatherapi.mapper.CityMapper;
import com.m2.tiila.weatherapi.repository.CityRepository;
//import dto.weather.City;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.m2.tiila.weatherapi.mapper.CityMapper.cityToDto;


@Component
public class CityBusness {

    @Inject
    private CityRepository cityRepository;


    public void createCity(CityEntity cityEntity){
        if(cityEntity.getId() != null)
            this.cityRepository.createCity(cityToDto(cityEntity));
        else
            throw  new FunctionalException("ID_NULL", "L'id de la city ne doit pas etre null");
    }

    public void updateCity(String id, CityEntity cityEntity){
        this.cityRepository.updateCity(id, cityToDto(cityEntity));
    }

    public void deleteCity(String id){
        this.cityRepository.deleteCity(id);
    }

    public List<City> getAll(){
       return  this.cityRepository.getAll();
    }

//    public City getCity(String id){
//        return this.cityRepository.getCity(id);
//    }
}
