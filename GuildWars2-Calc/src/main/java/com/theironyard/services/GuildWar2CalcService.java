package com.theironyard.services;

import com.theironyard.entities.Item;
import com.theironyard.entities.Price;
import com.theironyard.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by EddyJ on 7/25/16.
 */
@Service
public class GuildWar2CalcService {

    @Autowired
    RestTemplate restTemplate;

    public static final String RECIPE_URL = "https://api.guildwars2.com/v2/recipes/";

    public static final String ITEM_URL = "https://api.guildwars2.com/v2/items/";

    public static final String PRICE_URL = "https://api.guildwars2.com/v2/commerce/prices/";


    public Recipe getByRecipe(Integer id){
        Recipe recipe = restTemplate.getForObject(RECIPE_URL + id, Recipe.class);
        return recipe;
    }

    public Item getByOutputItem(Integer id){
        Item item = restTemplate.getForObject(ITEM_URL + id, Item.class);
        return item;
    }

    public Item getIngredientList(Recipe recipe){
        List<Item> itemList = recipe.getIngredients();
        Item foundItems = null;
        for (Item item : itemList){
            item = restTemplate.getForObject(ITEM_URL + item.getId(), Item.class);
            foundItems = item;
        }
        return foundItems;
    }

    public Price getByPrice(Integer id, List<Item> objectList){
        Price price = restTemplate.getForObject(PRICE_URL + id, Price.class);
        return price;
    }
}
