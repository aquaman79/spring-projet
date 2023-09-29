package com.m2.tiila.weatherapi.exception;

import java.util.function.Function;

public class FunctionalException extends RuntimeException{

    private String code;
    private String description;

    public FunctionalException(String code, String description){
        super(description);
        this.code = code ;
    }
    public String getCode(){
        return this.code;
    }

}
