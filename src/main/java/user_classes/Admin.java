package user_classes;

import model_classes.enums;

public class Admin extends User
{
    public Admin()
    {
    }

    public Admin(String username, String password, String name, String surname, String uloga, String phone, String email)
    {
        super(username, password, name, surname, phone, email);
        this.setUloga(enums.Roles.ADMINISTRATOR);
    }
}
