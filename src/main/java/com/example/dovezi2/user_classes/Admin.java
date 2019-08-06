package com.example.dovezi2.user_classes;

import com.example.dovezi2.model_classes.enums;

public class Admin extends User
{
    public Admin()
    {
    }

    public Admin(User parentUser)
    {
        super(parentUser.getUsername(), parentUser.getPassword(), parentUser.getName(),
                parentUser.getSurname(), parentUser.getPhone(), parentUser.getEmail());
        this.setUloga(enums.Roles.ADMINISTRATOR);
    }
}
