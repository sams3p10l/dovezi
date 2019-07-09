package dao;

import loadnsave.UserLoader;
import user_classes.User;

import java.util.*;

public class UserDAO
{
    private UserLoader userLoader = new UserLoader();

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
