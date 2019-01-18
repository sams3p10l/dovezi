package model_classes;

public class Vehicle
{
    private String marka;
    private String model;
    private enums.Vehicles tip;
    private String regOznaka;
    private int godiste;
    private boolean voziloAktivno;
    private String napomena;

    public Vehicle()
    {
    }

    public Vehicle(String marka, String model, enums.Vehicles tip, String regOznaka, int godiste, boolean voziloAktivno, String napomena) //da li treba aktivno??
    {
        this.marka = marka;
        this.model = model;
        this.tip = tip;
        this.regOznaka = regOznaka;
        this.godiste = godiste;
        this.voziloAktivno = voziloAktivno;
        this.napomena = napomena;
    }

    public String getMarka()
    {
        return marka;
    }

    public void setMarka(String marka)
    {
        this.marka = marka;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getRegOznaka()
    {
        return regOznaka;
    }

    public enums.Vehicles getTip()
    {
        return tip;
    }

    public void setRegOznaka(String regOznaka)
    {
        this.regOznaka = regOznaka;
    }

    public int getGodiste()
    {
        return godiste;
    }

    public void setGodiste(int godiste)
    {
        this.godiste = godiste;
    }

    public boolean isVoziloAktivno()
    {
        return voziloAktivno;
    }

    public void setVoziloAktivno(boolean voziloAktivno)
    {
        this.voziloAktivno = voziloAktivno;
    }

    public String getNapomena()
    {
        return napomena;
    }

    public void setNapomena(String napomena)
    {
        this.napomena = napomena;
    }

    public void setTip(enums.Vehicles tip)
    {
        this.tip = tip;
    }
}
