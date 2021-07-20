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

    private Long Id_Location;

    private String Adress;

    private Integer Max_Pers;

    private Integer Id_Person_Host;

    public LocationDTO(Long id_Location, String adress, Integer max_Pers, Integer id_Person_Host) {
        Id_Location = id_Location;
        Adress = adress;
        Max_Pers = max_Pers;
        Id_Person_Host = id_Person_Host;
    }

    public Long getId_Location() {
        return Id_Location;
    }

    public void setId_Location(Long id_Location) {
        Id_Location = id_Location;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public Integer getMax_Pers() {
        return Max_Pers;
    }

    public void setMax_Pers(Integer max_Pers) {
        Max_Pers = max_Pers;
    }

    public Integer getId_Person_Host() {
        return Id_Person_Host;
    }

    public void setId_Person_Host(Integer id_Person_Host) {
        Id_Person_Host = id_Person_Host;
    }
}
