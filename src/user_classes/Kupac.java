package user_classes;

import model_classes.Order;
import model_classes.Restaurant;
import model_classes.enums;

import java.util.ArrayList;

public class Kupac extends User
{
    private ArrayList<Order> orderList;
    private ArrayList<Restaurant> restaurantList;

    public Kupac()
    {
    }

    public Kupac(String username, String password, String name, String surname, enums.Roles uloga, String phone, String email, ArrayList<Order> orderList, ArrayList<Restaurant> restaurantList)
    {
        super(username, password, name, surname, uloga, phone, email);
        this.orderList = orderList;
        this.restaurantList = restaurantList;
    }

    public ArrayList<Order> getOrderList()
    {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList)
    {
        this.orderList = orderList;
    }

    public ArrayList<Restaurant> getRestaurantList()
    {
        return restaurantList;
    }

    public void setRestaurantList(ArrayList<Restaurant> restaurantList)
    {
        this.restaurantList = restaurantList;
    }
}
