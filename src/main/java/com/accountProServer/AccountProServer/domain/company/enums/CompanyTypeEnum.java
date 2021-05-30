package com.accountProServer.AccountProServer.domain.company.enums;

import com.accountProServer.AccountProServer.domain.EnumType;

public enum CompanyTypeEnum implements EnumType {
    Shares("Company limited by shares",0),
    Guarantee("limited by guarantee",1),
    Unlimited("Unlimited company",2);

    private String presentValue;
    private int dataBaseValue;

    CompanyTypeEnum(String presentValue, int dataBaseValue) {
        this.presentValue = presentValue;
        this.dataBaseValue = dataBaseValue;
    }

    public String getPresentValue() {
        return presentValue;
    }

    public int getDataBaseValue() {
        return dataBaseValue;
    }
}