package com.example.demo.model.book;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Isbn {
    private final String value;

    public Isbn(String value) {
        Objects.requireNonNull(value, "Book ISBN can not be null");
        this.value = value;
    }
}
