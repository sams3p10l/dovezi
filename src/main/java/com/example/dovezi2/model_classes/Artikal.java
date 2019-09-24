package com.example.dovezi2.model_classes;

public abstract class Artikal
{
    private String id;
    private String naziv;
    private double cena;
    private String opis;
    private int kolicina;
    protected enums.ArtikalTypes type;

    public Artikal()
    {
        this.id = "";
        this.naziv = "";
        this.cena = 0.0;
        this.opis = "";
        this.kolicina = 0;
    }

    public Artikal(String naziv, double cena, String opis, int kolicina)
    {
        this.naziv = naziv;
        this.cena = cena;
        this.opis = opis;
        this.kolicina = kolicina;
        this.id = naziv + opis;
        this.id = this.id.toUpperCase().replace(" ", "-");
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public enums.ArtikalTypes getType()
    {
        return type;
    }

    public void setType(enums.ArtikalTypes type)
    {
        this.type = type;
    }

    public String getNaziv()
    {
        return naziv;
    }

    public void setNaziv(String naziv)
    {
        this.naziv = naziv;
    }

    public double getCena()
    {
        return cena;
    }

    public void setCena(double cena)
    {
        this.cena = cena;
    }

    public String getOpis()
    {
        return opis;
    }

    public void setOpis(String opis)
    {
        this.opis = opis;
    }

    public int getKolicina()
    {
        return kolicina;
    }

    public void setKolicina(int kolicina)
    {
        this.kolicina = kolicina;
    }

    abstract String printKolicina();
}
