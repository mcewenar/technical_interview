package com.example.demo.model.book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@ToString
@Data
@NoArgsConstructor
public class Isbn {
    private String value;

    public Isbn(String value) {
        Objects.requireNonNull(value, "Book ISBN can not be null");
        this.value = value;
    }
}
