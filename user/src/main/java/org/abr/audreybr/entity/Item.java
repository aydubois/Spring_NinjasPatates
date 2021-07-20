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
    private Long Id;

    @Column
    private String Type;

    @Column
    private Integer Percentage_Consumed;

    @Column
    private Integer Measure;

    @Column
    private Integer Quantity;

    @Column
    private Integer Unit;

    public Item(Long id, String type, Integer percentage_Consumed, Integer measure, Integer quantity, Integer unit) {
        Id = id;
        Type = type;
        Percentage_Consumed = percentage_Consumed;
        Measure = measure;
        Quantity = quantity;
        Unit = unit;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Integer getPercentage_Consumed() {
        return Percentage_Consumed;
    }

    public void setPercentage_Consumed(Integer percentage_Consumed) {
        Percentage_Consumed = percentage_Consumed;
    }

    public Integer getMeasure() {
        return Measure;
    }

    public void setMeasure(Integer measure) {
        Measure = measure;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Integer getUnit() {
        return Unit;
    }

    public void setUnit(Integer unit) {
        Unit = unit;
    }

}
