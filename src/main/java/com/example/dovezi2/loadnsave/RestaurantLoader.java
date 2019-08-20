package com.example.dovezi2.loadnsave;

import com.example.dovezi2.model_classes.Restaurant;
import com.example.dovezi2.model_classes.enums;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        for (Object restObject : jsonArray)
        {
            JSONObject obj = (JSONObject) restObject;

            //String id = (String) obj.get("id");
            String name = (String) obj.get("name");
            String address = (String) obj.get("address");
            enums.Categories category = restString2Enum((String) obj.get("category"));

            JSONArray arrayOfFoods = (JSONArray) obj.get("listOfFoods");
            ArrayList<String> foodList = new ArrayList<>();

            for (Object foodObject : arrayOfFoods)
            {
                foodList.add(foodObject.toString());
            }

            JSONArray arrayOfDrinks = (JSONArray) obj.get("listOfDrinks");
            ArrayList<String> drinkList = new ArrayList<>();

            for (Object drinkObject : arrayOfDrinks)
            {
                drinkList.add(drinkObject.toString());
            }

            //boolean delete = (boolean)jsonObject.get("delete");

            Restaurant newRestaurant = new Restaurant(name, address, category, foodList, drinkList);
            allRestaurants.put(newRestaurant.getNaziv(), newRestaurant);

        }
    }

    private enums.Categories restString2Enum(String rest)
    {
        switch (rest)
        {
            case "DOMACA_KUHINJA":
            {
                return enums.Categories.DOMACA_KUHINJA;
                //break;
            }
            case "ROSTILJ":
            {
                return enums.Categories.ROSTILJ;
            }
            case "KINESKI_RESTORAN":
            {
                return enums.Categories.KINESKI_RESTORAN;
            }
            case "INDIJSKI_RESTORAN":
            {
                return enums.Categories.INDIJSKI_RESTORAN;
            }
            case "POSLASTICARNICA":
            {
                return enums.Categories.POSLASTICARNICA;
            }
            case "PICERIJA":
            {
                return enums.Categories.PICERIJA;
            }
        }

        return null;
    }

    public Map<String, Restaurant> getAllRestaurants()
    {
        return allRestaurants;
    }

}
