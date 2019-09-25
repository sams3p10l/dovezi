package com.example.dovezi2.dao;

import com.example.dovezi2.loadnsave.ItemLoader;
import com.example.dovezi2.loadnsave.ItemSaver;
import com.example.dovezi2.loadnsave.RestaurantLoader;
import com.example.dovezi2.loadnsave.RestaurantSaver;
import com.example.dovezi2.model_classes.Restaurant;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RestaurantDAO
{
    private RestaurantLoader restaurantLoader = new RestaurantLoader();
    private RestaurantSaver restaurantSaver = new RestaurantSaver();

    private ItemSaver itemSaver = new ItemSaver();
    private ItemLoader itemLoader = new ItemLoader();

    public Collection<Restaurant> getAllRestaurants()
    {
        ArrayList<Restaurant> retVal = new ArrayList<>();

        for(Restaurant rest : restaurantLoader.getAllRestaurants().values()){
            retVal.add(rest);
            //TODO: add delete check
        }

        return retVal;
    }

    public Restaurant getRestaurantByName(String name) {
        for(Restaurant restaurant : restaurantLoader.getAllRestaurants().values()) {
            if(restaurant.getNaziv().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    public Collection<Restaurant> getRestaurantsByCategory(String category)
    {
        Collection<Restaurant> retVal = new ArrayList<>();
        String kat = category.toUpperCase();

        for(Restaurant rest : restaurantLoader.getAllRestaurants().values()){
            if (kat.equals(rest.getKategorija().name()))
            {   //TODO: delete check
                retVal.add(rest);
            }
        }

        return retVal;
    }

    public Collection<Restaurant> getRestaurantsByAddress(String address)
    {
        Collection<Restaurant> retVal = new ArrayList<>();

        for (Restaurant rest : restaurantLoader.getAllRestaurants().values()){
            if (rest.getAdresa().contains(address))
                retVal.add(rest);
        }

        return retVal;
    }

    public void saveRestaurants()
    {
        restaurantSaver.save(restaurantLoader.getAllRestaurants().values());
    }

    public void loadRestaurants() throws IOException, ParseException
    {
        restaurantLoader.loadRestaurants();
    }

    public void saveItems()
    {
        itemSaver.save(itemLoader.getAllItems().values());
    }

    public void loadItems()
    {
        itemLoader.loadItems();
    }

}
