package model_classes;

import java.util.ArrayList;

public class Restaurant
{
    private String naziv;
    private String adresa;
    private enums.Categories kategorija;
    private ArrayList<String> mealList;
    private ArrayList<String> drinkList;

    public Restaurant()
    {
    }

    public Restaurant(String naziv, String adresa, enums.Categories kategorija, ArrayList<String> mealList, ArrayList<String> drinkList)
    {
        this.naziv = naziv;
        this.adresa = adresa;
        this.kategorija = kategorija;
        this.mealList = mealList;
        this.drinkList = drinkList;
    }

    public String getNaziv()
    {
        return naziv;
    }

    public void setNaziv(String naziv)
    {
        this.naziv = naziv;
    }

    public String getAdresa()
    {
        return adresa;
    }

    public void setAdresa(String adresa)
    {
        this.adresa = adresa;
    }

    public enums.Categories getKategorija()
    {
        return kategorija;
    }

    public void setKategorija(enums.Categories kategorija)
    {
        this.kategorija = kategorija;
    }

    public ArrayList<String> getMealList()
    {
        return mealList;
    }

    public void setMealList(ArrayList<String> mealList)
    {
        this.mealList = mealList;
    }

    public ArrayList<String> getDrinkList()
    {
        return drinkList;
    }

    public void setDrinkList(ArrayList<String> drinkList)
    {
        this.drinkList = drinkList;
    }
}
