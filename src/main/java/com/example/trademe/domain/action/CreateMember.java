package com.example.trademe.domain.action;

import java.util.Objects;

public class CreateMember {
    public final String firstname;
    public final String lastname;
    public final String username;
    public final String password;

    public CreateMember(String firstname, String lastname, String username, String password) {
        Objects.requireNonNull(firstname);
        Objects.requireNonNull(lastname);
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }
}
