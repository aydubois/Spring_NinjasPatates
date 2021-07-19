package org.abr.audreybr.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
public class ChouilleDTO implements Serializable {

    private Long Id;

    private String Thematic;

    private java.sql.Date Date;

    public ChouilleDTO(Long id, String thematic, java.sql.Date date) {
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
