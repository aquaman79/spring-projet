package com.m2.tiila.weatherapi.entity;

import lombok.Data;

@Data
public class CityEntity {
    String id;
    String name;
    String region;
    String country;
    Integer codepostale;
}
