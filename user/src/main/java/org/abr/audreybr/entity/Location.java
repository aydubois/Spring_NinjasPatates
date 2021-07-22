package org.abr.audreybr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Embeddable
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id_Location;

    @Column
    private String Adress;

    @Column
    private Integer Max_Pers;

    @Column
    private Integer Id_Person_Host;

    public Location(Integer id_Location, String adress, Integer max_Pers, Integer id_Person_Host) {
        Id_Location = id_Location;
        Adress = adress;
        Max_Pers = max_Pers;
        Id_Person_Host = id_Person_Host;
    }

    public Integer getId_Location() {
        return Id_Location;
    }

    public void setId_Location(Integer id_Location) {
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
