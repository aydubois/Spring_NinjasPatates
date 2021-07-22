package org.abr.audreybr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_Location;

    @Column
    private String adress;

    @Column
    private Integer max_Pers;

    @ManyToOne
    @JoinColumn (name="Id_Person_Host")
    private Person host;

    /*@OneToMany(mappedBy="location")
    private List<Chouille> chouilles;*/

    public Location(Integer id_Location, String adress, Integer max_Pers, Person host) {
        this.id_Location = id_Location;
        this.adress = adress;
        this.max_Pers = max_Pers;
        this.host = host;
    }

    public Integer getId_Location() {
        return id_Location;
    }

    public void setId_Location(Integer id_Location) {
        this.id_Location = id_Location;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getMax_Pers() {
        return max_Pers;
    }

    public void setMax_Pers(Integer max_Pers) {
        this.max_Pers = max_Pers;
    }

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }

   /* public List<Chouille> getChouilles() {
        return chouilles;
    }

    public void addChouilles(Chouille chouille) {
        if(!this.chouilles.contains(chouille))
        this.chouilles.add(chouille);
    }*/
}
