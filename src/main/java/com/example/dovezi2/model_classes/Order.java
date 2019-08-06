package com.example.dovezi2.model_classes;

import java.util.Date;
import java.util.HashMap;

import com.example.dovezi2.user_classes.*;

public class Order
{
    //TODO: give order ID's for deliverers
    private String orderID;
    private HashMap<Artikal, Integer> stavka;
    private Date timestamp;
    private Customer customer;
    private Deliverer deliverer;
    private String napomena;
    private enums.Statuses status;

    private static int idIterator = 0;

    public Order()
    {
        this.orderID = setID();
    }

    public Order(HashMap<Artikal, Integer> stavka, String napomena)
    {
        this.orderID = setID();
        this.stavka = stavka;
        this.napomena = napomena;
        this.timestamp = new Date();
    }

    private String setID()
    {
        return "Order" + (idIterator++);
    }

    public String getOrderID()
    {
        return orderID;
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

    public enums.Statuses getStatus()
    {
        return status;
    }

    public void setStatus(enums.Statuses status)
    {
        this.status = status;
    }
}
