package com.accountProServer.AccountProServer.domain.secretaryFirm;

import java.util.ArrayList;
import java.util.List;

public class SecretaryFirm {
    private final String firmRegisterNumber;
    private final String name;
    private final String email;
    private final String telephone;
    private final String address;
    private List<Secretary> secretaries = new ArrayList<>();

    public SecretaryFirm(String firmRegisterNumber, String name, String email, String telephone, String address) {
        this.firmRegisterNumber = firmRegisterNumber;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public List<Secretary> getSecretaries() {
        return secretaries;
    }

    public void addSecretary(Secretary secretary) {
        secretaries.add(secretary);
    }

    public String getFirmRegisterNumber() {
        return firmRegisterNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }
}
