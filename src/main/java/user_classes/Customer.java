package user_classes;

import model_classes.Order;
import model_classes.Restaurant;
import model_classes.enums;

import java.util.ArrayList;

public class Customer extends User
{
    private ArrayList<String> orderIDList;
    private ArrayList<String> restaurantIDList;
    private int userPoints;

    public Customer()
    {
    }

    public Customer(String username, String password, String name, String surname,
                    String uloga, String phone, String email,
                    ArrayList<String> orderList, ArrayList<String> restaurantList, int pts)
    {
        super(username, password, name, surname, uloga, phone, email);
        this.orderIDList = orderList;
        this.restaurantIDList = restaurantList;
        this.userPoints = pts;
    }

    public ArrayList<String> getOrderList()
    {
        return orderIDList;
    }

    public void setOrderList(ArrayList<String> orderList)
    {
        this.orderIDList = orderList;
    }

    public ArrayList<String> getRestaurantList()
    {
        return restaurantIDList;
    }

    public void setRestaurantList(ArrayList<String> restaurantList)
    {
        this.restaurantIDList = restaurantList;
    }

    public int getUserPoints()
    {
        return userPoints;
    }

    public void setUserPoints(int userPoints)
    {
        this.userPoints = userPoints;
    }
}
