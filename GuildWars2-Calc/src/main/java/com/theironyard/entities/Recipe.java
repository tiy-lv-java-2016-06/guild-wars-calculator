package com.theironyard.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by EddyJ on 7/25/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {

    private Integer id;

    private String type;

    @JsonProperty("time_to_craft_ms")
    private Integer timeToCraft;

    private ArrayList<String> disciplines;

    private ArrayList<Item> ingredients;

    @JsonProperty("output_item_id")
    private Integer outputItemId;

    public Recipe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTimeToCraft() {
        return timeToCraft;
    }

    public void setTimeToCraft(Integer timeToCraft) {
        this.timeToCraft = timeToCraft;
    }

    public ArrayList<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<String> disciplines) {
        this.disciplines = disciplines;
    }

    public ArrayList<Item> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Item> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getOutputItemId() {
        return outputItemId;
    }

    public void setOutputItemId(Integer outputItemId) {
        this.outputItemId = outputItemId;
    }
}
