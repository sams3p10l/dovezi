package user_classes;

import model_classes.Order;
import model_classes.Vehicle;
import model_classes.enums;

import java.util.ArrayList;

public class Dostavljac extends User
{
    private Vehicle vozilo;
    private ArrayList<Order> allocatedOrders;

    public Dostavljac()
    {
    }

    public Dostavljac(String username, String password, String name, String surname, enums.Roles uloga, String phone, String email, Vehicle vozilo, ArrayList<Order> allocatedOrders)
    {
        super(username, password, name, surname, uloga, phone, email);
        this.vozilo = vozilo;
        this.allocatedOrders = allocatedOrders;
    }

    public Vehicle getVozilo()
    {
        return vozilo;
    }

    public void setVozilo(Vehicle vozilo)
    {
        this.vozilo = vozilo;
    }

    public ArrayList<Order> getAllocatedOrders()
    {
        return allocatedOrders;
    }

    public void setAllocatedOrders(ArrayList<Order> allocatedOrders)
    {
        this.allocatedOrders = allocatedOrders;
    }
}
