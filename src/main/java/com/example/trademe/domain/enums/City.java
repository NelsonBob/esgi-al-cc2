package com.example.trademe.domain.enums;

public enum City {
    PARIS(75, "Paris");

    private int code;
    private String name;

    City(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
