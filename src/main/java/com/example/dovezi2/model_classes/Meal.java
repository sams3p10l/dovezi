package com.example.dovezi2.model_classes;

public class Meal extends Artikal
{
    public Meal(){}

    public Meal(String pNaziv, double pCena, String pOpis, int pKolicina, String pRestaurant){
        super(pNaziv, pCena, pOpis, pKolicina, pRestaurant);
        super.type = enums.ArtikalTypes.HRANA;
    }

    String printKolicina()
    {
        return super.getKolicina() + " gr";
    }
}
