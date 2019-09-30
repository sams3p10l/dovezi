package com.example.dovezi2.dao;

import com.example.dovezi2.loadnsave.UserLoader;
import com.example.dovezi2.loadnsave.UserSaver;
import com.example.dovezi2.model_classes.enums;
import com.example.dovezi2.user_classes.Admin;
import com.example.dovezi2.user_classes.Customer;
import com.example.dovezi2.user_classes.Deliverer;
import com.example.dovezi2.user_classes.User;

import java.util.*;

public class UserDAO
{
    private static UserLoader userLoader;
    private UserSaver userSaver;

    public UserDAO()
    {
        userLoader = new UserLoader();
        userSaver = new UserSaver();
    }

    public boolean findUser(String username)
    {
        return userLoader.getUsers().containsKey(username);
    }

    public void addUser(User pUser)
    {
        if(pUser != null)
        {
            userLoader.getUsers().put(pUser.getUsername(), pUser);

            if(pUser.getUloga().equals(enums.Roles.ADMINISTRATOR))
            {
                Admin newAdmin = new Admin(pUser);
                userLoader.getAdmins().put(newAdmin.getUsername(), newAdmin);
            }
            else if(pUser.getUloga().equals(enums.Roles.DOSTAVLJAC))
            {
                Deliverer newDeliverer = new Deliverer(pUser);
                userLoader.getDeliverers().put(newDeliverer.getUsername(), newDeliverer);
            }
            else if(pUser.getUloga().equals(enums.Roles.KUPAC))
            {
                Customer newCustomer = new Customer(pUser);
                userLoader.getCustomers().put(newCustomer.getUsername(), newCustomer);
            }
        }
    }

    public void saveUsers()
    {
        userSaver.save(getAllUserCollection());
    }

    public void loadUsers()
    {
        userLoader.loadAllUsers();
    }

    public User getUser(String username)
    {
        if (userLoader.getUsers().containsKey(username))
            return userLoader.getUsers().get(username);

        return null;
    }

    private Map getUsers()
    {
        return userLoader.getUsers();
    }

    public Collection<User> getAllUserCollection() {
        return userLoader.getUsers().values();
    }

    public static UserLoader getUserLoader()
    {
        return userLoader;
    }

    public void setCustomerFunction(String pUsername, enums.Roles pUloga)
    {
        Collection<User> mUsers = getAllUserCollection();
        Collection<Customer> mCustomers = userLoader.getCustomers().values();

        for (User user : mUsers)
        {
            if (user.getUsername().equals(pUsername))
                user.setUloga(pUloga);
        }

        for (Customer customer : mCustomers)
        {
            if (customer.getUsername().equals(pUsername))
                customer.setUloga(pUloga);
        }

        HashMap<String, User> newMapUsers = new HashMap<>();
        for (User newUser : mUsers)
            newMapUsers.put(newUser.getUsername(), newUser);

        HashMap<String, Customer> newMapCustomers = new HashMap<>();
        for (Customer newCustomer : mCustomers)
            newMapCustomers.put(newCustomer.getUsername(), newCustomer);

        userLoader.setAllUsers(newMapUsers);
        userLoader.setCustomers(newMapCustomers);
    }

    public void setAdminFunction(String pUsername, enums.Roles pUloga)
    {
        Collection<User> mUsers = getAllUserCollection();
        Collection<Admin> mAdmins = userLoader.getAdmins().values();

        for (User user : mUsers)
        {
            if (user.getUsername().equals(pUsername))
                user.setUloga(pUloga);
        }

        for (Admin admin : mAdmins)
        {
            if (admin.getUsername().equals(pUsername))
                admin.setUloga(pUloga);
        }

        HashMap<String, User> newMapUsers = new HashMap<>();
        for (User newUser : mUsers)
            newMapUsers.put(newUser.getUsername(), newUser);

        HashMap<String, Admin> newMapAdmins = new HashMap<>();
        for (Admin newAdmin : mAdmins)
            newMapAdmins.put(newAdmin.getUsername(), newAdmin);

        userLoader.setAllUsers(newMapUsers);
        userLoader.setAdmins(newMapAdmins);
    }

    public void setDelivererFunction(String pUsername, enums.Roles pUloga)
    {
        Collection<User> mUsers = getAllUserCollection();
        HashMap<String, Deliverer> newMapDeliverers = new HashMap<>();

        enums.Roles oldRole = null;

        for (User user : mUsers)
        {
            if (user.getUsername().equals(pUsername)) {
                oldRole = user.getUloga();
                user.setUloga(pUloga);
            }
        }

        for (User newUser : mUsers)
        {
            if (newUser.getUloga().equals(enums.Roles.DOSTAVLJAC))
            {
                if (oldRole != null) {
                    if (oldRole.equals(enums.Roles.KUPAC))
                    {
                        userLoader.getCustomers().remove(pUsername);
                    }
                    else if (oldRole.equals(enums.Roles.ADMINISTRATOR))
                    {
                        userLoader.getAdmins().remove(pUsername);
                    }

                    newMapDeliverers.put(newUser.getUsername(), new Deliverer(newUser));
                }
            }
        }

        userLoader.setDeliverers(newMapDeliverers);
    }
}
