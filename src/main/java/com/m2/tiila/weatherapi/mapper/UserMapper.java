package com.m2.tiila.weatherapi.mapper;

import com.m2.tiila.weatherapi.dto.User;
import com.m2.tiila.weatherapi.entity.CityEntity;
import com.m2.tiila.weatherapi.entity.UserEntity;
import dto.weatherapi.City;

public class UserMapper {
    public static UserEntity userToEntity(User user){
      UserEntity userEntity = new UserEntity();
      userEntity.setId(user.getId());
      userEntity.setLogin(user.getLogin());
      userEntity.setPassword(user.getPassword());
      return userEntity;
    }

    public static User userEntityToDto(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setPassword(userEntity.getPassword());
        user.setLogin(userEntity.getLogin());
        return user;

    }
}
