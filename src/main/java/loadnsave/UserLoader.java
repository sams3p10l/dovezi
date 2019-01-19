package loadnsave;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import user_classes.Admin;
import user_classes.Customer;
import user_classes.Deliverer;
import user_classes.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.parser.JSONParser;

public class UserLoader //loading and parsing data from json
{
    private Map<String, User> allUsers = new HashMap<String, User>();

    private ArrayList<Admin> admins = new ArrayList<Admin>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Deliverer> deliverers = new ArrayList<Deliverer>();

    public UserLoader()
    {
        loadAdmins();
        loadCustomers();
        loadDeliverers();
    }

    private void loadCustomers() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();

        try {

            JSONArray jsonArray = (JSONArray) parser.parse
                    (new FileReader("E:\\Misa\\Docs\\Web\\dovezi2\\web\\data"));

            for (Object obj : jsonArray)
            {
                JSONObject jsonObject = (JSONObject) obj;

                String username = (String) jsonObject.get("username");
                String password = (String) jsonObject.get("password");
                String firstName = (String) jsonObject.get("firstname");
                String lastName = (String) jsonObject.get("lastname");
                String role = (String) jsonObject.get("role"); //cemu?
                String phone = (String) jsonObject.get("phone");
                String email = (String) jsonObject.get("email");
                String regDate = (String) jsonObject.get("regdate");
                int points = Integer.parseInt((String) jsonObject.get("points"));
                JSONArray userOrders = (JSONArray) jsonObject.get("orderList");
                JSONArray userRestaurants = (JSONArray) jsonObject.get("restaurantList");

                ArrayList<String> orderList = new ArrayList<String>();
                for (Object userOrder : userOrders) {
                    orderList.add((String) userOrder);
                }

                ArrayList<String> restaurantList = new ArrayList<String>();
                for (Object userRestaurant : userRestaurants) {
                    restaurantList.add((String) userRestaurant);
                }

                User userCustomer = new User(username, password, firstName, lastName, role, phone,
                                                                email, regDate);
                allUsers.put(userCustomer.getUsername(), userCustomer);

                Customer newCustomer = new Customer(username, password, firstName, lastName, role, phone,
                                                                email, orderList, restaurantList);
                customers.add(newCustomer);

            }

        }

    }

    private void loadAdmins()
    {
        JSONParser parser = new JSONParser();

    }

    private void loadDeliverers()
    {
        JSONParser parser = new JSONParser();

    }

    public Map<String, User> getUsers()
    {
        return allUsers;
    }
}
