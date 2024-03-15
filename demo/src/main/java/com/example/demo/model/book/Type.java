package com.example.demo.model.book;

import java.util.Objects;

public class Type {
    private final String value;

    public Type(String value) {
        Objects.requireNonNull(value, "Book type can not be null");
        this.value = value;
    }
}
