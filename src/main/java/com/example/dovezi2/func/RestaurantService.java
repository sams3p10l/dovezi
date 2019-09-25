package com.example.dovezi2.func;

import com.example.dovezi2.dao.RestaurantDAO;
import com.example.dovezi2.model_classes.Restaurant;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("restaurants")
public class RestaurantService
{
    @Context
    ServletContext ctx;

    @Context
    HttpServletRequest request;

    private RestaurantDAO restaurantDAO = new RestaurantDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/restorani")
    public Collection<Restaurant> getAllRestaurants(){
        return restaurantDAO.getAllRestaurants();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/restorani/ime={name}")
    public Restaurant getRestaurantByName(@PathParam("name")String name){
        return restaurantDAO.getRestaurantByName(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/restorani/kategorija={cat}")
    public Collection<Restaurant> getRestaurantByCategory(@PathParam("cat")String cat){
        return restaurantDAO.getRestaurantsByCategory(cat);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/restorani/adresa={adr}")
    public Collection<Restaurant> getRestaurantsByAddress(@PathParam("adr")String adresa){
        return restaurantDAO.getRestaurantsByAddress(adresa);
    }
}
