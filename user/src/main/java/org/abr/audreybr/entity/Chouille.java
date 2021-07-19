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
    private Long Id;

    @Column
    private String Thematic;
    @Column
    private Date Date;

    public Chouille(Long id, String thematic, java.sql.Date date) {
        Id = id;
        Thematic = thematic;
        Date = date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
}
