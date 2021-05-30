package com.accountProServer.AccountProServer.domain.company.enums;


import com.accountProServer.AccountProServer.domain.EnumType;

/**
 * Origin of Company
 */
public enum CompanyOriginEnum implements EnumType{
    In("Incorporated in Malaysia", 0),
    Outside("Incorporated outside Malaysia", 1);
    private String presentValue;
    private int dataBaseValue;

    CompanyOriginEnum(String presentValue, int dataBaseValue) {
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