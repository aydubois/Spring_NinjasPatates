package org.abr.audreybr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Item {

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
    private String Unit;

    @Column
    private Integer Percentage_Consumed;

    @Column
    private Long Id_Person;

    @Column
    private Long Id_Chouille;


    public Item(Long id_Item, String type, Integer quantity, Integer measure, String unit, Integer percentage_Consumed, Long id_Person, Long id_Chouille) {
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

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Integer getPercentage_Consumed() {
        return Percentage_Consumed;
    }

    public void setPercentage_Consumed(Integer percentage_Consumed) {
        Percentage_Consumed = percentage_Consumed;
    }

    public Long getId_Person() {
        return Id_Person;
    }

    public void setId_Person(Long id_Person) {
        Id_Person = id_Person;
    }

    public Long getId_Chouille() {
        return Id_Chouille;
    }

    public void setId_Chouille(Long id_Chouille) {
        Id_Chouille = id_Chouille;
    }
}
