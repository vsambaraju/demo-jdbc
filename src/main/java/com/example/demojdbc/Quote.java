package com.example.demojdbc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String type;
    private Value Value;

    public Quote() {
    }

    public Quote(String type, Value value) {
        this.type = type;
        Value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return Value;
    }

    public void setValue(Value value) {
        Value = value;
    }
}
