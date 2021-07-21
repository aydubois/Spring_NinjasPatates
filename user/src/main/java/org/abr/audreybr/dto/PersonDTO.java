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
public class PersonDTO implements Serializable {

    private Integer Id_Person;

    private String name;

    public PersonDTO(Integer id_Person, String name) {
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
