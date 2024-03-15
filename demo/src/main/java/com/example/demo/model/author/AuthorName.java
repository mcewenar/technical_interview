package com.example.demo.model.author;

import java.util.Objects;

public class AuthorName {
    private final String value;

    public AuthorName(String value) {
        Objects.requireNonNull(value, "AuthorName can not be null");
        this.value = value;
    }
}
