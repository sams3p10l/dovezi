package com.example.dovezi2.loadnsave;

import com.example.dovezi2.model_classes.Restaurant;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestaurantLoader
{
    private Map<String, Restaurant> allRestaurants = new HashMap<>();

    String path = RestaurantLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public RestaurantLoader()
    {
        try {
            loadRestaurants();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void loadRestaurants() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();

        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path + "../../data/restaurants.json"));
    }

}
