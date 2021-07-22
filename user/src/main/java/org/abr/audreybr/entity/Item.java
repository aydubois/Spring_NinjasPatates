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
    private Integer id_Item;

    @Column
    private String type;

    @Column
    private Integer quantity;

    @Column
    private Integer measure;

    @Column
    private String unit;

    @Column
    private Integer percentage_Consumed;

    @ManyToOne
    @JoinColumn (name="Id_Person")
    private Person person;

    @ManyToOne
    @JoinColumn (name="Id_Chouille")
    private Chouille chouille;

    public Item(Integer id_Item, String type, Integer quantity, Integer measure, String unit, Integer percentage_Consumed, Person person, Chouille chouille) {
        this.id_Item = id_Item;
        this.type = type;
        this.quantity = quantity;
        this.measure = measure;
        this.unit = unit;
        this.percentage_Consumed = percentage_Consumed;
        this.person = person;
        this.chouille = chouille;
    }

    public Integer getId_Item() {
        return id_Item;
    }

    public void setId_Item(Integer id_Item) {
        this.id_Item = id_Item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMeasure() {
        return measure;
    }

    public void setMeasure(Integer measure) {
        this.measure = measure;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPercentage_Consumed() {
        return percentage_Consumed;
    }

    public void setPercentage_Consumed(Integer percentage_Consumed) {
        this.percentage_Consumed = percentage_Consumed;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Chouille getChouille() {
        return chouille;
    }

    public void setChouille(Chouille chouille) {
        this.chouille = chouille;
    }
}
