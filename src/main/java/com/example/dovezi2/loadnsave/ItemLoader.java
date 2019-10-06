package com.example.dovezi2.loadnsave;

import com.example.dovezi2.model_classes.Artikal;
import com.example.dovezi2.model_classes.Drink;
import com.example.dovezi2.model_classes.Meal;
import com.example.dovezi2.model_classes.enums;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ItemLoader
{
    private HashMap<String, Artikal> allItems = new HashMap<>();
    private HashMap<String, Meal> allMeals = new HashMap<>();
    private HashMap<String, Drink> allDrinks = new HashMap<>();

    private JSONParser jsonParser = new JSONParser();

    private String path = ItemSaver.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public ItemLoader(){
        loadItems();
    }

    public void loadItems()
    {
        try {
            JSONArray array = (JSONArray) jsonParser.parse(new FileReader(path + "../../data/items.json"));

            for(Object obj : array)
            {
                JSONObject jsonObject = (JSONObject) obj;

                String id = (String) jsonObject.get("id");
                String restaurant = (String) jsonObject.get("restaurant");
                String name = (String) jsonObject.get("name");
                String cena = (String) jsonObject.get("price");
                double price = Double.parseDouble(cena);
                String description = (String) jsonObject.get("description");
                String kolicina = (String) jsonObject.get("quantity");
                int quantity = Integer.parseInt(kolicina);
                String tip = (String) jsonObject.get("typeOfItem");
                enums.ArtikalTypes type = null;

                if (tip.equals("HRANA"))
                    type = enums.ArtikalTypes.HRANA;
                if (tip.equals("PICE"))
                    type = enums.ArtikalTypes.PICE;

                if (type == enums.ArtikalTypes.HRANA) {
                    Meal newMeal = new Meal(name, price, description, quantity, restaurant);
                    allItems.put(newMeal.getId(), newMeal);
                    allMeals.put(newMeal.getId(), newMeal);
                }
                else if (type == enums.ArtikalTypes.PICE) {
                    Drink newDrink = new Drink(name, price, description, quantity, restaurant);
                    allItems.put(newDrink.getId(), newDrink);
                    allDrinks.put(newDrink.getId(), newDrink);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Artikal> getAllItems()
    {
        return allItems;
    }

    public void setAllItems(HashMap<String, Artikal> allItems)
    {
        this.allItems = allItems;
    }

    public HashMap<String, Meal> getAllMeals()
    {
        return allMeals;
    }

    public HashMap<String, Drink> getAllDrinks()
    {
        return allDrinks;
    }
}
