package com.example.demo.model.book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Type {
    private String value;

    public Type(String value) {
        Objects.requireNonNull(value, "Book type can not be null");
        this.value = value;
    }
}
