package com.example.trademe.domain.id;

import lombok.ToString;

@ToString
public class MemberId {
    private final int id;

    public MemberId(int id) { this.id = id; }

    private static MemberId of(int id) { return new MemberId(id); }

    public int getId() { return id; }
}
