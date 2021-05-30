package com.accountProServer.AccountProServer.domain.secretaryFirm;

import com.accountProServer.AccountProServer.domain.valueObject.NRIC;


public class Secretary {
    private final String id;
    private final String name;
    private final String status;
    private final String licenseNumber;
    private final NRIC secretaryNRIC;
    public Secretary(String id, String name, String status, String licenseNumber, NRIC secretaryNRIC) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.licenseNumber = licenseNumber;
        this.secretaryNRIC = secretaryNRIC;
    }
}
