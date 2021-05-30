package com.accountProServer.AccountProServer.domain.valueObject;

public class NRIC {
    private final String value;
    public NRIC(String value){
        this.value=value;
    }
    public String getValue() {
        return value;
    }
}
