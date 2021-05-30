package com.accountProServer.AccountProServer.domain.company;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private final String registerNumber;
    private final String formerlyKnownAs;
    private final String name;
    private final String oldRegisterNo;
    private final String originOfCompany;
    private final String statusOfCompany;
    private final String typeOfCompany;
    private final String address;

    public Company(String registerNumber, String formerlyKnownAs, String name, String oldRegisterNo, String originOfCompany, String statusOfCompany, String typeOfCompany, String address) {
        this.registerNumber = registerNumber;
        this.formerlyKnownAs = formerlyKnownAs;
        this.name = name;
        this.oldRegisterNo = oldRegisterNo;
        this.originOfCompany = originOfCompany;
        this.statusOfCompany = statusOfCompany;
        this.typeOfCompany = typeOfCompany;
        this.address = address;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    private List<Director> directors = new ArrayList<>();
    private ContactPerson contactPerson;

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getFormerlyKnownAs() {
        return formerlyKnownAs;
    }

    public String getName() {
        return name;
    }

    public String getOldRegisterNo() {
        return oldRegisterNo;
    }

    public String getOriginOfCompany() {
        return originOfCompany;
    }

    public String getStatusOfCompany() {
        return statusOfCompany;
    }

    public String getTypeOfCompany() {
        return typeOfCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void addDirectors(Director director) {
        this.directors.add(director);
    }

    public List<Director> getAllDirectors() {
        return directors;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public Director getDirectors(String id) {
        return directors.stream().filter(director -> director.getId().equals(id)).findFirst().get();
    }
}
