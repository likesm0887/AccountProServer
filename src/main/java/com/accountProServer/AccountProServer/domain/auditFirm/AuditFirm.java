package com.accountProServer.AccountProServer.domain.auditFirm;

public class AuditFirm {
    private final String auditFirmNumber;
    private final String address;
    private final String name;
    public AuditFirm( String auditFirmNumber, String address, String name) {
        this.auditFirmNumber = auditFirmNumber;
        this.address = address;
        this.name = name;
    }

    public String getAuditFirmNumber() {
        return auditFirmNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
