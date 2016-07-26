package com.theironyard.Controllers;

import com.theironyard.Entities.GuildWarsRecipe;
import com.theironyard.Entities.Item;
import com.theironyard.Services.GuildwarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nigel on 7/25/16.
 */
@Controller
public class GuildWarsApiController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GuildwarsService guildwarsService;

    /**
     *
     * @param id
     * @param model
     * @return return home.html for the user.
     */
    @RequestMapping(path = "/recipes/{id}", method = RequestMethod.GET)
    public String getRecipe(@PathVariable int id, Model model){

        /**Hit the Guild Wars API to get values for the recipe object**/
        String url = "https://api.guildwars2.com/v2/recipes/";
        GuildWarsRecipe recipe = restTemplate.getForObject(url + id, GuildWarsRecipe.class);

        /**Hit the Guild Wars API to get the name of the item, using that item's Id.**/
        String itemUrl = "https://api.guildwars2.com/v2/items/";
        List<Item> items = recipe.getIngredients();
        Item returnItem;
        for(Item item : items){
           Map detail = restTemplate.getForObject(itemUrl + item.getId(), HashMap.class);
            item.setName((String)detail.get("name"));
        }

        /**Hit the Guild Wars API to get the buy price of each item**/
        String priceUrl = "https://api.guildwars2.com/v2/commerce/prices/";
        for(Item item : items) {
            Map buys = restTemplate.getForObject(priceUrl + item.getId(), HashMap.class);
            Map buy = (Map)buys.get("buys");
            item.setPrice((int)buy.get("unit_price"));
        }

        /**Calculate total of the item to create.**/
        int overallTotal = 0;
        for (Item item : items) {
            overallTotal += item.getTotal();
        }

        /**Models for the use in the HTML file**/
        model.addAttribute("overallTotal", overallTotal);
        model.addAttribute("recipe", recipe);

        return "home";
    }

}