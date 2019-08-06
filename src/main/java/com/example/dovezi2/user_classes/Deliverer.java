package com.example.dovezi2.user_classes;

import com.example.dovezi2.model_classes.*;
import java.util.ArrayList;

public class Deliverer extends User
{
    private Vehicle vozilo;
    private ArrayList<Order> allocatedOrders;

    public Deliverer()
    {
    }

    public Deliverer(User parentUser)
    {
        super(parentUser.getUsername(), parentUser.getPassword(), parentUser.getName(),
                parentUser.getSurname(), parentUser.getPhone(), parentUser.getEmail());
        this.vozilo = new Vehicle();
        this.allocatedOrders = new ArrayList<>();
        this.setUloga(enums.Roles.DOSTAVLJAC);
    }

    public Deliverer(User parentUser, Vehicle vozilo, ArrayList<Order> allocatedOrders)
    {
        super(parentUser.getUsername(), parentUser.getPassword(), parentUser.getName(),
                parentUser.getSurname(), parentUser.getPhone(), parentUser.getEmail());
        this.vozilo = vozilo;
        this.allocatedOrders = allocatedOrders;
        this.setUloga(enums.Roles.DOSTAVLJAC);
    }

    @Override
    public String getUsername()
    {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username)
    {
        super.setUsername(username);
    }

    @Override
    public String getPassword()
    {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password)
    {
        super.setPassword(password);
    }

    @Override
    public String getName()
    {
        return super.getName();
    }

    @Override
    public void setName(String name)
    {
        super.setName(name);
    }

    @Override
    public String getSurname()
    {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname)
    {
        super.setSurname(surname);
    }

    @Override
    public enums.Roles getUloga()
    {
        return super.getUloga();
    }

    @Override
    public void setUloga(enums.Roles uloga)
    {
        super.setUloga(uloga);
    }

    @Override
    public String getPhone()
    {
        return super.getPhone();
    }

    @Override
    public void setPhone(String phone)
    {
        super.setPhone(phone);
    }

    @Override
    public String getEmail()
    {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email)
    {
        super.setEmail(email);
    }

    @Override
    public String getRegDate()
    {
        return super.getRegDate();
    }

    public String getVozilo()
    {
        return vozilo.getTip().name();
    }

    public void setVozilo(Vehicle vozilo)
    {
        this.vozilo = vozilo;
    }

    public ArrayList<String> getAllocatedOrderIDs()
    {
        ArrayList<String> retval = new ArrayList<>();

        for(Order order : allocatedOrders)
            retval.add(order.getOrderID());

        return retval;
    }

    public void setAllocatedOrders(ArrayList<Order> allocatedOrders)
    {
        this.allocatedOrders = allocatedOrders;
    }
}
