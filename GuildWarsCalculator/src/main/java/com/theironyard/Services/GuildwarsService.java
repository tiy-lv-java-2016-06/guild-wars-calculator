package com.theironyard.Services;

import com.theironyard.Entities.GuildWarsRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nigel on 7/25/16.
 */

@Service
public class GuildwarsService {

    @Autowired
    RestTemplate restTemplate;

    public static final String BASE_URL = "https://api.guildwars2.com/v2/";

    public GuildWarsRecipe getById(int id) {

        GuildWarsRecipe recipe;
        recipe = restTemplate.getForObject(BASE_URL + id, GuildWarsRecipe.class);

        return recipe;
    }

}
