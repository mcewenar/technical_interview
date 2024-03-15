package com.example.demo.model.author;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class BirthDate {
    private final Date value;

    public BirthDate(Date value) {
        Objects.requireNonNull(value, "BirthDate can not be null");
        this.value = value;
    }
}
