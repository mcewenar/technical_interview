package com.example.demo.model.author;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
@Data
@NoArgsConstructor
public class BirthDate {
    private LocalDate value;

    public BirthDate(LocalDate value) {
        Objects.requireNonNull(value, "BirthDate can not be null");
        this.value = value;
    }
}
