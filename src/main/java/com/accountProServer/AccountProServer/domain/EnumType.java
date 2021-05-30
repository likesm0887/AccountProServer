package com.accountProServer.AccountProServer.domain;

public interface EnumType<T extends Enum> {
    public String getPresentValue();

    public int getDataBaseValue();

}
