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


    private Long Id;

    private String Type;

    private Integer Percentage_Consumed;

    private Integer Measure;

    private Integer Quantity;

    private Integer Unit;

    public ItemDTO(Long id, String type, Integer percentage_Consumed, Integer measure, Integer quantity, Integer unit) {
        Id = id;
        Type = type;
        Percentage_Consumed = percentage_Consumed;
        Measure = measure;
        Quantity = quantity;
        Unit = unit;
    }

}
