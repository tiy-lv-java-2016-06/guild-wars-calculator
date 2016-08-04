package com.theironyard.controllers;

import com.theironyard.entities.Item;
import com.theironyard.entities.Recipe;
import com.theironyard.services.GuildWar2CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by EddyJ on 7/25/16.
 */
@Controller
public class GuildWars2CalcController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GuildWar2CalcService guildWar2CalcService;

    @RequestMapping(path = "/recipes/{id}", method = RequestMethod.GET)
    public String getRecipe(@PathVariable Integer id, Model model){
        Recipe recipe = guildWar2CalcService.getByRecipe(id);
        model.addAttribute("recipe", recipe);
        model.addAttribute("item", guildWar2CalcService.getByOutputItem(recipe.getOutputItemId()));
        model.addAttribute("ingredientItem", guildWar2CalcService.getByIngredients(recipe));
        return "home";
    }
}
