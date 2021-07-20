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
public class ItemDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id_Item;

    @Column
    private String type;

    @Column
    private Integer Quantity;

    @Column
    private Integer Measure;

    @Column
    private Integer Unit;

    @Column
    private Integer Percentage_Consumed;

    @Column
    private Integer Id_Person;

    @Column
    private Integer Id_Chouille;

    public ItemDTO(Long id_Item, String type, Integer quantity, Integer measure, Integer unit, Integer percentage_Consumed, Integer id_Person, Integer id_Chouille) {
        Id_Item = id_Item;
        this.type = type;
        Quantity = quantity;
        Measure = measure;
        Unit = unit;
        Percentage_Consumed = percentage_Consumed;
        Id_Person = id_Person;
        Id_Chouille = id_Chouille;
    }

    public Long getId_Item() {
        return Id_Item;
    }

    public void setId_Item(Long id_Item) {
        Id_Item = id_Item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Integer getMeasure() {
        return Measure;
    }

    public void setMeasure(Integer measure) {
        Measure = measure;
    }

    public Integer getUnit() {
        return Unit;
    }

    public void setUnit(Integer unit) {
        Unit = unit;
    }

    public Integer getPercentage_Consumed() {
        return Percentage_Consumed;
    }

    public void setPercentage_Consumed(Integer percentage_Consumed) {
        Percentage_Consumed = percentage_Consumed;
    }

    public Integer getId_Person() {
        return Id_Person;
    }

    public void setId_Person(Integer id_Person) {
        Id_Person = id_Person;
    }

    public Integer getId_Chouille() {
        return Id_Chouille;
    }

    public void setId_Chouille(Integer id_Chouille) {
        Id_Chouille = id_Chouille;
    }
}
