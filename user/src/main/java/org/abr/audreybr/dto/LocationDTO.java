package org.abr.audreybr.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
public class LocationDTO implements Serializable {

    private Long Id;

    private Integer Max_Pers;

    private String Adress;

    public LocationDTO(Long id, Integer max_Pers, String adress) {
        Id = id;
        Max_Pers = max_Pers;
        Adress = adress;
    }

}
