package com.theironyard.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nigel on 7/26/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("item_id")
    private int id;

    private int count;

    private String name;

    @JsonProperty("buys.unit_price")
    private int price;

    private int total;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        total = count * price;
        return total;
    }
}