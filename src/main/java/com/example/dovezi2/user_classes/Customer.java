package com.example.dovezi2.user_classes;

import java.util.ArrayList;

public class Customer extends User
{
    private ArrayList<String> orderIDList;
    private ArrayList<String> restaurantIDList;
    private int userPoints;

    public Customer()
    {
    }

    public Customer(User parentUser)
    {
        super(parentUser.getUsername(), parentUser.getPassword(), parentUser.getName(),
                parentUser.getSurname(), parentUser.getPhone(), parentUser.getEmail());
        this.orderIDList = new ArrayList<>();
        this.restaurantIDList = new ArrayList<>();
        this.userPoints = 0;
    }

    public Customer(User parentUser, ArrayList<String> orderList, ArrayList<String> restaurantList, int pts)
    {
        super(parentUser.getUsername(), parentUser.getPassword(), parentUser.getName(),
                parentUser.getSurname(), parentUser.getUloga().name(), parentUser.getPhone(),
                parentUser.getEmail(), parentUser.getRegDate());
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
