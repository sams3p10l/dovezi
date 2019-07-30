package com.example.dovezi2.dao;

import com.example.dovezi2.loadnsave.UserLoader;
import com.example.dovezi2.loadnsave.UserSaver;
import com.example.dovezi2.user_classes.User;

import java.util.*;

public class UserDAO
{
    private UserLoader userLoader = new UserLoader();
    private UserSaver userSaver = new UserSaver();

    public UserDAO() {}

    public boolean findUser(String username)
    {
        return userLoader.getUsers().containsKey(username);
    }

    public void addUser(User pUser)
    {
        if(pUser != null)
            userLoader.getUsers().put(pUser.getUsername(), pUser);

        //TODO: role check

        /*if(user.getUserFunction().equals(TypeOfUser.ADMINISTRATOR)){
            Administrator newAdmin = changeToAdmin(user);
            loadUsers.getListOfAdministrators().add(newAdmin);

        }else if(user.getUserFunction().equals(TypeOfUser.DOSTAVLJAC)) {
            Deliverer newDeliverer = changeToDeliverer(user);
            loadUsers.getListOfDeliverers().add(newDeliverer);
        }else if(user.getUserFunction().equals(TypeOfUser.KUPAC)){
            Customer newCustomer = changeToCustomer(user);
            loadUsers.getListOfCustomers().add(newCustomer);
        }*/
    }

    public void saveUsers()
    {
        userSaver.save((ArrayList<User>) getAllUserObj());
    } //TODO: ovde greska

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

    public Map getUsers()
    {
        return userLoader.getUsers();
    }

    public Collection<User> getAllUserObj() {
        return userLoader.getUsers().values();
    }
}
