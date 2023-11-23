package com.m2.tiila.weatherapi.Buisness;

import com.m2.tiila.weatherapi.dto.User;
import com.m2.tiila.weatherapi.entity.PrevisionEntity;
import com.m2.tiila.weatherapi.repository.CityRepository;
import com.m2.tiila.weatherapi.repository.UserRepository;
import com.m2.tiila.weatherapi.repository.WeatherReposity;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.m2.tiila.weatherapi.mapper.WeitherMapper.toEntity;

@Component

public class WeatherBusiness {


    @Inject
    private  WeatherReposity weatherReposity;

    @Inject
    private CityRepository cityRepository;
    @Inject
    private UserRepository userRepository;

    public  PrevisionEntity getCityWeather(String city,String user) {
        List<City> cities = cityRepository.getAll();

        if(user.equals("admin")) {
            return toEntity(weatherReposity.getCityWeather(city));
        } else {
            for (City cityItem : cities) {
                if (cityItem.getName().equalsIgnoreCase(city)) {
                    return toEntity(weatherReposity.getCityWeather(city));
                }
            }
        }

        return null;
    }

}