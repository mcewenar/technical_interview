package com.example.demo.model.book;

import java.util.Objects;

public class PageNumber {
    private final Integer value;

    public PageNumber(Integer value) {
        Objects.requireNonNull(value, "Page number can not be null");
        this.value = value;
    }
}
