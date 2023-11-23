package com.m2.tiila.weatherapi.repository;

import com.m2.tiila.weatherapi.dto.User;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Component
public class UserRepository {

    private final static String SQL_INSERT_USER = "INSERT INTO USERS (ID,LOGIN,PASSWORD) VALUES(:id,:login,:password)";
    private final static String SQL_SELECT_User = "SELECT * FROM USERS WHERE ID = :id";

    @Inject // je veux que tu injecte tous les config de la bdd ici
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public void createUser(User user){
        //preparer les parametres
        var params = new HashMap<String,String>();
        params.put("id",user.getId());
        params.put("login",user.getLogin());
        params.put("password",user.getPassword());
        this.namedParameterJdbcTemplate.update(SQL_INSERT_USER,params);
    }

    public User findUser(String id){
        var params = new HashMap<String,String>();
        params.put("id",id);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_User, params, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("ID"));
                user.setLogin(rs.getString("LOGIN"));
                user.setPassword(rs.getString("PASSWORD"));
                return user;
            }
        });
    }
}
