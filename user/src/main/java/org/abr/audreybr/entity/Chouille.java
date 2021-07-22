package org.abr.audreybr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class Chouille {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id_Chouille;

    @Column
    private String Thematic;

    @Column
    private Date Date;

    @ManyToOne
    @JoinColumn (name="Id_Location")
    private Location Location;

    @Column
    private Integer Id_Person_Sam;

    @Column
    private Integer Id_Person_Bouncer;

    @Column
    private String code;

    public Chouille(Integer id_Chouille, String thematic, java.sql.Date date, Location location, Integer id_Person_Sam, Integer id_Person_Bouncer, String code) {
        Id_Chouille = id_Chouille;
        Thematic = thematic;
        Date = date;
        Location = location;
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

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
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
