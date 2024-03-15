package com.example.demo.model.author;

import java.time.LocalDate;
import java.util.Objects;

public class YearsOld {
    private final Integer value;

    public YearsOld(Integer value) {
        Objects.requireNonNull(value, "YearsOld can not be null");
        this.value = value;
    }
}
