package com.m2.tiila.weatherapi.entity;

import lombok.Data;

import java.time.Instant;


@Data
public class PrevisionEntity {
    private Instant date;

    private String city;

    private String state;

    private float temperature;


}
