package loadnsave;

import user_classes.Admin;
import user_classes.Customer;
import user_classes.Deliverer;
import user_classes.User;

import java.util.ArrayList;
import java.util.HashMap;
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

    private void loadCustomers()
    {
        JSONParser parser = new JSONParser();

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
