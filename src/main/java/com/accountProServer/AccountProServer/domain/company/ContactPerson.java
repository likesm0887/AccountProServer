package com.accountProServer.AccountProServer.domain.company;

public class ContactPerson {
    private String name;
    private String position;
    private String telephone;

    public ContactPerson(String name, String position, String telephone, String email) {
        this.name = name;
        this.position = position;
        this.telephone = telephone;
        this.email = email;
    }

    private String email;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

}
