package com.example.dovezi2.loadnsave;

import com.example.dovezi2.dao.UserDAO;
import com.example.dovezi2.model_classes.enums;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.example.dovezi2.user_classes.*;

import javax.jws.soap.SOAPBinding;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UserSaver
{
    private Collection<User> users = new ArrayList<>();

    private JSONArray customersJson = new JSONArray();
    private JSONArray deliverersJson = new JSONArray();
    private JSONArray adminsJson = new JSONArray();

    private String path = UserSaver.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public UserSaver() {}

    public void save(Collection<User> pUsers)
    {
        this.users = pUsers;

        for (User mUser : users)
        {
            if (mUser.getUloga().equals(enums.Roles.KUPAC))
            {
                Map customersTemp = UserDAO.getUserLoader().getCustomers(); //da bi mogao da izvlacim podatke iz
                Customer grabbedCustomer;                                   //klase Customer a ne User

                if(customersTemp.containsKey(mUser.getUsername()))
                {
                    grabbedCustomer = (Customer) customersTemp.get(mUser.getUsername());

                    JSONObject newCustomer = new JSONObject();

                    newCustomer.put("username", grabbedCustomer.getUsername());
                    newCustomer.put("password", grabbedCustomer.getPassword());
                    newCustomer.put("firstName", grabbedCustomer.getName());
                    newCustomer.put("lastName", grabbedCustomer.getSurname());
                    newCustomer.put("email", grabbedCustomer.getEmail());
                    newCustomer.put("phone", grabbedCustomer.getPhone());
                    newCustomer.put("regDate", grabbedCustomer.getRegDate());
                    newCustomer.put("uloga", grabbedCustomer.getUloga().name());
                    newCustomer.put("points", String.valueOf(grabbedCustomer.getUserPoints()));

                    JSONArray listOfOrders = new JSONArray();
                    ArrayList<String> list1 = grabbedCustomer.getOrderList();
                    listOfOrders.addAll(list1);
                    newCustomer.put("orderList", listOfOrders);

                    JSONArray listOfRestaurants = new JSONArray();
                    ArrayList<String> list2 = grabbedCustomer.getRestaurantList();
                    listOfRestaurants.addAll(list2);
                    newCustomer.put("restaurantList", listOfRestaurants);

                    customersJson.add(newCustomer);
                }
            }
            else if (mUser.getUloga().equals(enums.Roles.DOSTAVLJAC))
            {
                Map deliverersTemp = UserDAO.getUserLoader().getDeliverers();
                Deliverer grabbedDeliverer;

                if(deliverersTemp.containsKey(mUser.getUsername()))
                {
                    grabbedDeliverer = (Deliverer) deliverersTemp.get(mUser.getUsername());

                    JSONObject newDeliverer = new JSONObject();

                    newDeliverer.put("username", grabbedDeliverer.getUsername());
                    newDeliverer.put("password", grabbedDeliverer.getPassword());
                    newDeliverer.put("firstName", grabbedDeliverer.getName());
                    newDeliverer.put("lastName", grabbedDeliverer.getSurname());
                    newDeliverer.put("email", grabbedDeliverer.getEmail());
                    newDeliverer.put("phone", grabbedDeliverer.getPhone());
                    newDeliverer.put("regDate", grabbedDeliverer.getRegDate());
                    newDeliverer.put("uloga", grabbedDeliverer.getUloga().name());
                    newDeliverer.put("vehicle", grabbedDeliverer.getVozilo());

                    JSONArray listOfOrdersDeliverer = new JSONArray();
                    ArrayList<String> list = grabbedDeliverer.getAllocatedOrderIDs();
                    listOfOrdersDeliverer.addAll(list);
                    newDeliverer.put("orderList", listOfOrdersDeliverer);

                    deliverersJson.add(newDeliverer);
                }
            }
            else if(mUser.getUloga().equals(enums.Roles.ADMINISTRATOR))
            {
                Map adminsTemp = UserDAO.getUserLoader().getAdmins();
                Admin grabbedAdmin;

                if(adminsTemp.containsKey(mUser.getUsername()))
                {
                    grabbedAdmin = (Admin) adminsTemp.get(mUser.getUsername());

                    JSONObject newAdmin = new JSONObject();

                    newAdmin.put("username", grabbedAdmin.getUsername());
                    newAdmin.put("password", grabbedAdmin.getPassword());
                    newAdmin.put("firstName", grabbedAdmin.getName());
                    newAdmin.put("lastName", grabbedAdmin.getSurname());
                    newAdmin.put("email", grabbedAdmin.getEmail());
                    newAdmin.put("phone", grabbedAdmin.getPhone());
                    newAdmin.put("regDate", grabbedAdmin.getRegDate());
                    newAdmin.put("uloga", grabbedAdmin.getUloga().name());

                    adminsJson.add(newAdmin);
                }
            }
        }

        saveAllUsersJson();
        saveAdminsJson();
        saveCustomersJson();
        saveDeliverersJson();
    }

    private void saveAllUsersJson()
    {
        try(FileWriter fileAllUsers = new FileWriter(path + "../../data/allusers.json"))
        {
            fileAllUsers.write(String.valueOf(adminsJson.toString()));
            fileAllUsers.write(String.valueOf(customersJson.toString())); //toJsonString?
            fileAllUsers.write(String.valueOf(deliverersJson.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCustomersJson()
    {
        try(FileWriter fileCustomers = new FileWriter(path + "../../data/customers.json"))
        {
            fileCustomers.write(String.valueOf(customersJson.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveDeliverersJson()
    {
        try(FileWriter fileDeliverers = new FileWriter(path + "../../data/deliverer.json"))
        {
            fileDeliverers.write(String.valueOf(deliverersJson.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAdminsJson()
    {
        try(FileWriter fileAdmins = new FileWriter(path + "../../data/admins.json"))
        {
            fileAdmins.write(String.valueOf(adminsJson.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<User> getUsers()
    {
        return users;
    }

    public void setUsers(Collection<User> users)
    {
        this.users = users;
    }

}
