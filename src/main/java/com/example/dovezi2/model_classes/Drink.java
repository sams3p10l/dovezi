package com.example.dovezi2.model_classes;

public class Drink extends Artikal
{
    public Drink() {}

    public Drink(String pNaziv, double pCena, String pOpis, int pKolicina, String pRestaurant){
        super(pNaziv, pCena, pOpis, pKolicina, pRestaurant);
        super.type = enums.ArtikalTypes.PICE;
    }

    String printKolicina()
    {
        return super.getKolicina() + " ml";
    }
}
