package com.accountProServer.AccountProServer.adapter;

import java.util.ArrayList;
import java.util.List;

public class InputModel {
    private String tagName;
    private List<Attribute> attributes = new ArrayList<>();


    private String value;

    public InputModel() {
    }

    ;

    public InputModel(String tagName, List<Attribute> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public InputModel(String tagName, List<Attribute> attributes, String value) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.value = value;
    }

    public InputModel(String tagName, String value) {
        this.tagName = tagName;
        this.value = value;
    }

    public String getTagName() {
        return tagName;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getValue() {
        return value;
    }
}
