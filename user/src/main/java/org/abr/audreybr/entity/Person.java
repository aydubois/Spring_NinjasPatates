package org.abr.audreybr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id_Person;

    @Column
    private String name;

    public Person(Integer id_Person, String name) {
        Id_Person = id_Person;
        this.name = name;
    }

    public Integer getId_Person() {
        return Id_Person;
    }

    public void setId_Person(Integer id_Person) {
        Id_Person = id_Person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
