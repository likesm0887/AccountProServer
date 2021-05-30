package com.accountProServer.AccountProServer.domain.company.enums;

import com.accountProServer.AccountProServer.domain.EnumType;

public enum CompanyStatusEnum  implements EnumType {
    Private("Private company", 0),
    Public("Public company", 1);

    private String presentValue;
    private int dataBaseValue;

    CompanyStatusEnum(String presentValue, int dataBaseValue) {
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