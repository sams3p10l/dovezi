package model_classes;

public class Meal extends Artikal
{
    String printKolicina()
    {
        return super.getKolicina() + " gr";
    }
}
