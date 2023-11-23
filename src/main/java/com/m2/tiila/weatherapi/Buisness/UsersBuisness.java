package com.m2.tiila.weatherapi.Buisness;

import com.m2.tiila.weatherapi.dto.User;
import com.m2.tiila.weatherapi.entity.UserEntity;
import com.m2.tiila.weatherapi.repository.UserRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import static com.m2.tiila.weatherapi.mapper.UserMapper.userEntityToDto;

@Component
public class UsersBuisness {

    @Inject
    UserRepository userRepository;


    public void createUser(UserEntity user){
        this.userRepository.createUser(userEntityToDto(user));
    }

    public User find(String id){
        return this.userRepository.findUser(id);


    }
}
