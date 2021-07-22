package org.abr.audreybr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Person;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    private Integer enabled;

    public Person(Integer id_Person, String name) {
        this.id_Person = id_Person;
        this.username = name;
    }

    public Person(Integer id_Person, String name, String password) {
        this.id_Person = id_Person;
        this.username = name;
        this.password = password;
    }

    public Person(Integer id_Person, String name, String password, String role, Integer enabled ) {
        this.id_Person = id_Person;
        this.username = name;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }
    public Integer getId_Person() {
        return id_Person;
    }

    public void setId_Person(Integer id_Person) {
        this.id_Person = id_Person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
