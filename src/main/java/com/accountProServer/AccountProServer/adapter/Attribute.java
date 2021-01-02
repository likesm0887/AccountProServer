package com.accountProServer.AccountProServer.adapter;

public class Attribute {
    private final String name;
    private final String data;

    public Attribute(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}
