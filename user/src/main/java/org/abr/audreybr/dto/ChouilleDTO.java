package org.abr.audreybr.dto;

import lombok.Getter;
import lombok.Setter;
import org.abr.audreybr.dao.LocationRepository;
import org.abr.audreybr.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Optional;

@Getter
@Setter
public class ChouilleDTO implements Serializable {
    @Autowired
    LocationRepository repository;

    private Integer Id_Chouille;

    private String Thematic;

    private Date Date;

    private Location Location;

    private Integer Id_Person_Sam;

    private Integer Id_Person_Bouncer;

    private String code;

    public ChouilleDTO(Integer id_Chouille, String thematic, java.sql.Date date, Integer id_location, Integer id_Person_Sam, Integer id_Person_Bouncer, String code) {
        Id_Chouille = id_Chouille;
        Thematic = thematic;

        Optional<Location> locationOptional =  repository.findById(id_location);
        if(locationOptional.isPresent()){
            Location = locationOptional.get();
        }
        Date = date;
        Id_Person_Sam = id_Person_Sam;
        Id_Person_Bouncer = id_Person_Bouncer;
        this.code = code;
    }

    public Integer getId_Chouille() {
        return Id_Chouille;
    }

    public void setId_Chouille(Integer id_Chouille) {
        Id_Chouille = id_Chouille;
    }

    public String getThematic() {
        return Thematic;
    }

    public void setThematic(String thematic) {
        Thematic = thematic;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public Location geLocation() {
        return Location;
    }

    public void setLocation(Location Location) {
        Location = Location;
    }

    public Integer getId_Person_Sam() {
        return Id_Person_Sam;
    }

    public void setId_Person_Sam(Integer id_Person_Sam) {
        Id_Person_Sam = id_Person_Sam;
    }

    public Integer getId_Person_Bouncer() {
        return Id_Person_Bouncer;
    }

    public void setId_Person_Bouncer(Integer id_Person_Bouncer) {
        Id_Person_Bouncer = id_Person_Bouncer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
