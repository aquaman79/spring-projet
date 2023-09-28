package dto.weather;


import lombok.Data;

import java.io.Serializable;

@Data
public class City implements Serializable {

    String id;
    String name;
    String region;
    String country;
    String codepostale;

}