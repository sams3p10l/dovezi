package com.example.dovezi2.loadnsave;

import com.example.dovezi2.model_classes.Restaurant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RestaurantSaver
{
    private Collection<Restaurant> restaurants = new ArrayList<>();
    private JSONArray restaurantJSON = new JSONArray();

    private String path = RestaurantSaver.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public RestaurantSaver() {}

    public void save(Collection<Restaurant> pRest)
    {
        this.restaurants = pRest;

        for(Restaurant rest : restaurants)
        {
            JSONObject newRest = new JSONObject();

            newRest.put("id", rest.getId());
            newRest.put("name", rest.getNaziv());
            newRest.put("address", rest.getAdresa());

            switch (rest.getKategorija())
            {
                case DOMACA_KUHINJA:
                {
                    newRest.put("category", "DOMACA_KUHINJA");
                    break;
                }
                case ROSTILJ:
                {
                    newRest.put("category", "ROSTILJ");
                    break;
                }
                case POSLASTICARNICA:
                {
                    newRest.put("category", "POSLASTICARNICA");
                    break;
                }
                case KINESKI_RESTORAN:
                {
                    newRest.put("category", "KINESKI_RESTORAN");
                    break;
                }
                case INDIJSKI_RESTORAN:
                {
                    newRest.put("category", "INDIJSKI_RESTORAN");
                    break;
                }
                case PICERIJA:
                {
                    newRest.put("category", "PICERIJA");
                    break;
                }
            }

            JSONArray mealList = new JSONArray();
            mealList.addAll(rest.getMealList());

            JSONArray drinkList = new JSONArray();
            drinkList.addAll(rest.getDrinkList());

            newRest.put("listOfFoods", mealList);
            newRest.put("listOfDrinks", drinkList);

            restaurantJSON.add(newRest);
        }

        saveRestaurantsJson();
    }

    private void saveRestaurantsJson()
    {
        try(FileWriter fileRests = new FileWriter(path + "../../data/restaurants.json"))
        {
            fileRests.write(restaurantJSON.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
