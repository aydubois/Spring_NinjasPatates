package org.abr.audreybr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private Integer Max_Pers;

    @Column
    private String Adress;

    public Location(Long id, Integer max_Pers, String adress) {
        Id = id;
        Max_Pers = max_Pers;
        Adress = adress;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getMax_Pers() {
        return Max_Pers;
    }

    public void setMax_Pers(Integer max_Pers) {
        Max_Pers = max_Pers;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }
}
