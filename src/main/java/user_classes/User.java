package user_classes;

import model_classes.enums;
import model_classes.enums.Roles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static model_classes.enums.Roles;

public class User
{
    private String username;
    private String password;
    private String name;
    private String surname;
    private Roles uloga;
    private String phone;
    private String email;
    private String regDate;

    public User()
    {
        this.username = "";
        this.password = "";
        this.name = "";
        this.surname = "";
        this.uloga = Roles.KUPAC;
        this.phone = "";
        this.email = "";
        this.regDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /*for registration*/
    public User(String username, String password, String name, String surname, String phone, String email)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.uloga = Roles.KUPAC;
        this.phone = phone;
        this.email = email;
        this.regDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /* for loading from txt*/
    public User(String username, String password, String name, String surname, String role, String phone, String email, String date)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.uloga = string2role(role);
        this.phone = phone;
        this.email = email;
        this.regDate = date;
    }

    private Roles string2role(String uloga)
    {
        if (uloga.equals("KUPAC") || uloga.equals("DOSTAVLJAC") || uloga.equals("ADMINISTRATOR"))
        {
            if (uloga.equals("KUPAC"))
                return Roles.KUPAC;
            if (uloga.equals("DOSTAVLJAC"))
                return Roles.DOSTAVLJAC;

            return Roles.ADMINISTRATOR;
        }

        return null;
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Roles getUloga()
    {
        return uloga;
    }

    public void setUloga(Roles uloga)
    {
        this.uloga = uloga;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getRegDate()
    {
        return regDate;
    }
}


