package org.abr.audreybr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Chouille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Chouille;

    @Column
    private String thematic;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn (name="Id_Location")
    private Location location;

    @ManyToOne
    @JoinColumn (name="Id_Person_Sam")
    private Person sam;

    @ManyToOne
    @JoinColumn (name="Id_Person_Bouncer")
    private Person bouncer;

    @Column
    private String code;

    @ManyToMany
    @JoinTable(
            name = "Persons_Chouilles",
            joinColumns = @JoinColumn(name = "Id_chouille"),
            inverseJoinColumns = @JoinColumn(name = "Id_Person"))
    Set<Person> guests;

    public Chouille(Integer id_Chouille, String thematic, java.sql.Date date, Location location, Person sam, Person bouncer, String code) {
        this.id_Chouille = id_Chouille;
        this.thematic = thematic;
        this.date = date;
        this.location = location;
        this.sam = sam;
        this.bouncer = bouncer;
        this.code = code;
    }

    public Chouille( String thematic, java.sql.Date date, Location location, Person sam, Person bouncer, String code) {
        this.thematic = thematic;
        this.date = date;
        this.location = location;
        this.sam = sam;
        this.bouncer = bouncer;
        this.code = code;
    }
    public Integer getId_Chouille() {
        return id_Chouille;
    }

    public void setId_Chouille(Integer id_Chouille) {
        this.id_Chouille = id_Chouille;
    }

    public String getThematic() {
        return thematic;
    }

    public void setThematic(String thematic) {
        this.thematic = thematic;
    }

    public java.sql.Date getDate() {
        return this.date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person getSam() {
        return sam;
    }

    public void setSam(Person sam) {
        this.sam = sam;
    }

    public Person getBouncer() {
        return bouncer;
    }

    public void setBouncer(Person bouncer) {
        this.bouncer = bouncer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Person> getGuests() {
        return guests;
    }

    public void setGuests(Set<Person> guests) {
        this.guests = guests;
    }

    public void addGuest(Person guest){
        if(!this.guests.contains(guest)){
            this.guests.add(guest);
        }
    }

    public void deleteGuest(Person guest){
        if(this.guests.contains(guest))
            this.guests.remove(guest);
    }
}
