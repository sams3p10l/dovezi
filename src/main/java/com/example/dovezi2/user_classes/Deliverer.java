package com.example.dovezi2.user_classes;

import com.example.dovezi2.model_classes.*;
import java.util.ArrayList;

public class Deliverer extends User
{
    private enums.Vehicles vozilo;
    private ArrayList<String> allocatedOrders;

    public Deliverer()
    {
    }

    public Deliverer(User parentUser)
    {
        super(parentUser.getUsername(), parentUser.getPassword(), parentUser.getName(),
                parentUser.getSurname(), parentUser.getPhone(), parentUser.getEmail());
        this.allocatedOrders = new ArrayList<>();
        this.setUloga(enums.Roles.DOSTAVLJAC);
    }

    public Deliverer(User parentUser, String pVozilo, ArrayList<String> allocatedOrders)
    {
        super(parentUser.getUsername(), parentUser.getPassword(), parentUser.getName(),
                parentUser.getSurname(), parentUser.getPhone(), parentUser.getEmail());
        this.vozilo = string2vehicle(pVozilo);
        this.allocatedOrders = allocatedOrders;
        this.setUloga(enums.Roles.DOSTAVLJAC);
    }

    private enums.Vehicles string2vehicle(String uloga)
    {
        if (uloga.equals("BICIKL") || uloga.equals("SKUTER") || uloga.equals("AUTOMOBIL"))
        {
            if (uloga.equals("BICIKL"))
                return enums.Vehicles.BICIKL;
            if (uloga.equals("SKUTER"))
                return enums.Vehicles.SKUTER;

            return enums.Vehicles.AUTOMOBIL;
        }

        return null;
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
        return vozilo.name();
    }

    public void setVozilo(enums.Vehicles vozilo)
    {
        this.vozilo = vozilo;
    }

    public ArrayList<String> getAllocatedOrderIDs()
    {
        return allocatedOrders;
    }

    public void setAllocatedOrders(ArrayList<String> allocatedOrders)
    {
        this.allocatedOrders = allocatedOrders;
    }
}
