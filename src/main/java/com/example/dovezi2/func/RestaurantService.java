package com.example.dovezi2.func;

import com.example.dovezi2.dao.RestaurantDAO;
import com.example.dovezi2.model_classes.Drink;
import com.example.dovezi2.model_classes.Meal;
import com.example.dovezi2.model_classes.Restaurant;
import com.example.dovezi2.model_classes.enums;
import com.example.dovezi2.user_classes.User;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;

import static com.example.dovezi2.user_classes.User.string2role;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addRestaurant(Restaurant pRest)
    {
        HttpSession sesh = request.getSession();
        User loggedUser = (User) sesh.getAttribute("user_logged_in");

        if (loggedUser != null && loggedUser.getUloga().equals(enums.Roles.ADMINISTRATOR))
        {
            if(pRest.getNaziv() == null || pRest.getAdresa() == null || pRest.getKategorija() == null) {
                return Response.status(200).entity("Neuspesno dodavanje").build();
            }
            else
            {
                restaurantDAO.addNewRestaurant(pRest);
                restaurantDAO.saveRestaurants();
                try {
                    restaurantDAO.loadRestaurants();
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                return Response.status(200).entity("Restoran dodat").build();
            }
        }

        return Response.status(200).entity("Neuspesno dodavanje").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete={id}")
    public Response deleteRestaurant(@PathParam("id")String restID)
    {
        HttpSession sesh = request.getSession();
        User loggedUser = (User) sesh.getAttribute("user_logged_in");

        if (loggedUser != null && loggedUser.getUloga().equals(enums.Roles.ADMINISTRATOR))
        {
                restaurantDAO.deleteRestaurant(restID);
                restaurantDAO.saveRestaurants();
                try {
                    restaurantDAO.loadRestaurants();
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                return Response.status(200).entity("Restoran izbrisan").build();
        }

        return Response.status(200).entity("Greska u brisanju").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/edit={id}")
    public Response editRestaurant(@PathParam("id")String pid, Restaurant rest)
    {
        HttpSession sesh = request.getSession();
        User loggedUser = (User) sesh.getAttribute("user_logged_in");

        if (loggedUser != null && loggedUser.getUloga().equals(enums.Roles.ADMINISTRATOR))
        {
            Restaurant updated = new Restaurant(rest.getNaziv(), rest.getAdresa(), rest.getKategorija(), rest.getMealList(), rest.getDrinkList());

            restaurantDAO.editRestaurant(pid, updated);
            restaurantDAO.saveRestaurants();
            try {
                restaurantDAO.loadRestaurants();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            return Response.status(200).entity("Restoran azuriran").build();
        }

        return Response.status(200).entity("Greska prilikom azuriranja").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/restorani/{ime}/drinks")
    public Collection<Drink> getDrinks(@PathParam("ime")String pIme)
    {
        return restaurantDAO.getDrinks(pIme);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/restorani/{ime}/meals")
    public Collection<Meal> getMeals(@PathParam("ime")String pIme)
    {
        return restaurantDAO.getMeals(pIme);
    }
}
