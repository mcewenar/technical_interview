package com.example.demo.model.author;

import java.util.Objects;

public class AuthorCc {
    private final Integer value;

    public AuthorCc(Integer value) {
        Objects.requireNonNull(value, "CC can not be null");
        this.value = value;
    }
}
