package com.theironyard.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nigel on 7/25/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsRecipe {
    private int id;
    private String type;

    @JsonProperty("time_to_craft_ms")
    private int timeOfCraft;

    private List<String> disciplines = new ArrayList<>();

    private List<Item> ingredients = new ArrayList<>();

    public GuildWarsRecipe() {
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getTimeOfCraft() {
        return timeOfCraft;
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTimeOfCraft(int timeOfCraft) {
        this.timeOfCraft = timeOfCraft;
    }

    public void setDisciplines(List<String> disciplines) {
        this.disciplines = disciplines;
    }

    public List<Item> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Item> ingredients) {
        this.ingredients = ingredients;
    }
}
