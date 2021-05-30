package com.accountProServer.AccountProServer.domain.user;


import com.accountProServer.AccountProServer.domain.valueObject.NRIC;

public class User {
    private final String id;
    private final String account;
    private final String password;
    private NRIC userNRIC;
    private final String name;
    private String position;
    private String status;
    private String licenseNumber;
    private String licenseExpireDate;

    public User(String id, String account, String password, NRIC NRIC, String name, String position, String status, String licenseNumber, String licenseExpireDate) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.userNRIC = NRIC;
        this.name = name;
        this.position = position;
        this.status = status;
        this.licenseNumber = licenseNumber;
        this.licenseExpireDate = licenseExpireDate;
    }

    public String getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public NRIC getNRIC() {
        return userNRIC;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getStatus() {
        return status;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getLicenseExpireDate() {
        return licenseExpireDate;
    }
}
