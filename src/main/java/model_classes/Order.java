package model_classes;

import java.util.Date;
import java.util.HashMap;
import model_classes.enums.Statuses;
import user_classes.Deliverer;
import user_classes.Customer;

public class Order
{
    private HashMap<Artikal, Integer> stavka;
    private Date timestamp;
    private Customer customer;
    private Deliverer deliverer;
    private String napomena;
    private Statuses status;

    public Order()
    {
    }

    public Order(HashMap<Artikal, Integer> stavka, String napomena)
    {
        this.stavka = stavka;
        this.napomena = napomena;
        this.timestamp = new Date();
    }

    public HashMap<Artikal, Integer> getStavka()
    {
        return stavka;
    }

    public void setStavka(HashMap<Artikal, Integer> stavka)
    {
        this.stavka = stavka;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Deliverer getDeliverer()
    {
        return deliverer;
    }

    public void setDeliverer(Deliverer deliverer)
    {
        this.deliverer = deliverer;
    }

    public String getNapomena()
    {
        return napomena;
    }

    public void setNapomena(String napomena)
    {
        this.napomena = napomena;
    }

    public Statuses getStatus()
    {
        return status;
    }

    public void setStatus(Statuses status)
    {
        this.status = status;
    }
}
