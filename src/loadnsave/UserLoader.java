package loadnsave;

import user_classes.Admin;
import user_classes.Customer;
import user_classes.Deliverer;
import user_classes.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserLoader //loading and parsing data from json
{
    private Map<String, User> allUsers = new HashMap<>();

    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Deliverer> deliverers = new ArrayList<>();

    public UserLoader()
    {
        loadAdmins();
        loadCustomers();
        loadDeliverers();
    }

    private void loadCustomers()
    {


    }

    private void loadAdmins()
    {

    }

    private void loadDeliverers()
    {

    }

    public Map<String, User> getUsers()
    {
        return allUsers;
    }
}
