package model_classes;

public abstract class Artikal
{
    private String naziv;
    private double cena;
    private String opis;
    private int kolicina;

    public Artikal()
    {
    }

    public Artikal(String naziv, double cena, String opis, int kolicina)
    {
        this.naziv = naziv;
        this.cena = cena;
        this.opis = opis;
        this.kolicina = kolicina;
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
