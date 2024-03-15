package com.example.demo.model.book;

import java.util.Objects;

public class Name {
    private final String value;

    public Name(String value) {
        Objects.requireNonNull(value, "Name can not be null");
        this.value = value;
    }
}
