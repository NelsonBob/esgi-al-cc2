package com.example.trademe.domain.enums;

public enum Skill {
    ELECTRICIAN("ELCT", "Electrician"),
    PLUMBER("PL", "Plumber"),
    MASON("MS", "Mason");

    private String code;
    private String name;

    Skill(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
