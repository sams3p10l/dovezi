package com.example.dovezi2.loadnsave;

import com.example.dovezi2.model_classes.enums;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import com.example.dovezi2.user_classes.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.JSONParser;

public class UserLoader //loading and parsing data from json
{
    private Map<String, User> allUsers = new HashMap<String, User>();

    private Map<String, Admin> admins = new HashMap<>();
    private Map<String, Customer> customers = new HashMap<>();
    private Map<String, Deliverer> deliverers = new HashMap<>();

    String path = UserLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public UserLoader()
    {
        loadAllUsers();
    }

    public void loadAllUsers()
    {
        try {
            loadCustomers();
            loadAdmins();
            loadDeliverers();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void loadCustomers() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();

        JSONArray jsonArray = (JSONArray) parser.parse
                (new FileReader(path + "../../data/customers.json"));

        for (Object obj : jsonArray)
        {
            JSONObject jsonObject = (JSONObject) obj;

            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");
            String firstName = (String) jsonObject.get("firstName");
            String lastName = (String) jsonObject.get("lastName");
            String phone = (String) jsonObject.get("phone");
            String email = (String) jsonObject.get("email");
            String regDate = (String) jsonObject.get("regDate");
            JSONArray userOrderIDs = (JSONArray) jsonObject.get("orderList");
            JSONArray userRestaurantIDs = (JSONArray) jsonObject.get("restaurantList");

            int points = Integer.parseInt((String) jsonObject.get("points"));
            String role = enums.Roles.KUPAC.name();

            ArrayList<String> orderList = new ArrayList<String>();
            for (Object userOrder : userOrderIDs) {
                orderList.add((String) userOrder);
            }

            ArrayList<String> restaurantList = new ArrayList<String>();
            for (Object userRestaurant : userRestaurantIDs) {
                restaurantList.add((String) userRestaurant);
            }

            User userCustomer = new User(username, password, firstName, lastName, role, phone, //to the allUsers list
                                                            email, regDate);
            allUsers.put(userCustomer.getUsername(), userCustomer);

            Customer newCustomer = new Customer(userCustomer, orderList, restaurantList, points);
            customers.put(newCustomer.getUsername(), newCustomer);

        }

    }

    private void loadAdmins() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();

        JSONArray jsonArray = (JSONArray) parser.parse
                (new FileReader(path + "../../data/admins.json"));

        for (Object obj : jsonArray)
        {
            JSONObject jsonObject = (JSONObject) obj;

            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");
            String firstName = (String) jsonObject.get("firstName");
            String lastName = (String) jsonObject.get("lastName");
            String phone = (String) jsonObject.get("phone");
            String email = (String) jsonObject.get("email");
            String regDate = (String) jsonObject.get("regDate");

            String role = enums.Roles.ADMINISTRATOR.name();

            User userAdmin = new User(username, password, firstName, lastName, role, phone, //to the allUsers list
                    email, regDate);
            allUsers.put(userAdmin.getUsername(), userAdmin);

            Admin newAdmin = new Admin(userAdmin);
            admins.put(newAdmin.getUsername(), newAdmin);
        }

    }

    private void loadDeliverers() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();

        JSONArray jsonArray = (JSONArray) parser.parse
                (new FileReader(path + "../../data/deliverer.json"));

        for (Object obj : jsonArray)
        {
            JSONObject jsonObject = (JSONObject) obj;

            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");
            String firstName = (String) jsonObject.get("firstName");
            String lastName = (String) jsonObject.get("lastName");
            String phone = (String) jsonObject.get("phone");
            String email = (String) jsonObject.get("email");
            String regDate = (String) jsonObject.get("regDate");
            String vehicle = (String) jsonObject.get("vehicle");
            JSONArray userOrderIDs = (JSONArray) jsonObject.get("orderList");

            String role = enums.Roles.DOSTAVLJAC.name();

            ArrayList<String> orderList = new ArrayList<String>();
            for (Object userOrder : userOrderIDs) {
                orderList.add((String) userOrder);
            }

            User userDeliverer = new User(username, password, firstName, lastName, role, phone, //to the allUsers list
                    email, regDate);
            allUsers.put(userDeliverer.getUsername(), userDeliverer);

            Deliverer newDeliverer = new Deliverer(userDeliverer, vehicle, orderList);
            deliverers.put(newDeliverer.getUsername(), newDeliverer);

        }

    }

    public Map<String, User> getUsers()
    {
        return allUsers;
    }

    public Map<String, Admin> getAdmins()
    {
        return admins;
    }

    public Map<String, Customer> getCustomers()
    {
        return customers;
    }

    public Map<String, Deliverer> getDeliverers()
    {
        return deliverers;
    }
}
