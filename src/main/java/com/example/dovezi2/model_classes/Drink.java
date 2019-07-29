package com.example.dovezi2.model_classes;

public class Drink extends Artikal
{
    String printKolicina()
    {
        return super.getKolicina() + " ml";
    }
}
