package com.example.dovezi2.model_classes;

public class Meal extends Artikal
{
    public Meal(){
        super();
        super.type = enums.ArtikalTypes.HRANA;
    }

    String printKolicina()
    {
        return super.getKolicina() + " gr";
    }
}
