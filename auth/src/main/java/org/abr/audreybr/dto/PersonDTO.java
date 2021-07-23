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

    private String username;

    private String password;

    public PersonDTO(Integer id_Person, String username) {
        Id_Person = id_Person;
        this.username = username;
    }

    public Integer getId_Person() {
        return Id_Person;
    }

    public void setId_Person(Integer id_Person) {
        Id_Person = id_Person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
