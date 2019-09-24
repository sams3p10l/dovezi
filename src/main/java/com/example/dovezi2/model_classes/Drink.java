package com.example.dovezi2.model_classes;

public class Drink extends Artikal
{
    public Drink(){
        super();
        super.type = enums.ArtikalTypes.PICE;
    }

    String printKolicina()
    {
        return super.getKolicina() + " ml";
    }
}
