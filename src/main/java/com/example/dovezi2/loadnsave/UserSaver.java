package com.example.dovezi2.loadnsave;

import com.example.dovezi2.model_classes.enums;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.example.dovezi2.user_classes.*;

import javax.jws.soap.SOAPBinding;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class UserSaver
{
    private Collection<User> users = new ArrayList<>();

    private JSONArray customersJson = new JSONArray();
    private JSONArray deliverersJson = new JSONArray();
    private JSONArray adminsJson = new JSONArray();

    public UserSaver() {}

    public void save(Collection<User> pUsers)
    {
        this.users = pUsers;

        for (User mUser : users)
        {
            if (mUser.getUloga().equals(enums.Roles.KUPAC))
            {
                JSONObject newCustomer = new JSONObject();


                newCustomer.put("username", mUser.getUsername());
                newCustomer.put("password", mUser.getPassword());
                newCustomer.put("firstName", mUser.getName());
                newCustomer.put("lastName", mUser.getSurname());
                newCustomer.put("email", mUser.getEmail());
                newCustomer.put("phone", mUser.getPhone());
                newCustomer.put("regDate", mUser.getRegDate());
                newCustomer.put("uloga", mUser.getUloga().name());
                //newCustomer.put("points", m)

                customersJson.add(newCustomer);
            }
            else if (mUser.getUloga().equals(enums.Roles.DOSTAVLJAC))
            {

            }
        }

        saveAllUsersJson();

    }

    public void saveAllUsersJson()
    {
        try(FileWriter fileAllUsers = new FileWriter("../../../../../webapp/data/allusers.json"))
        {
            fileAllUsers.write(users.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<User> getUsers()
    {
        return users;
    }

    public void setUsers(ArrayList<User> users)
    {
        this.users = users;
    }

}
