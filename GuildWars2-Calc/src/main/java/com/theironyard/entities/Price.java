package com.theironyard.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

/**
 * Created by EddyJ on 7/26/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    @JsonProperty("item_id")
    private Integer id;

    @JsonProperty("buys.unit_price")
    private Integer unitPrice;


    public Price() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }
}
