package com.example.demo.model.book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Name {
    private String value;

    public Name(String value) {
        Objects.requireNonNull(value, "Name can not be null");
        this.value = value;
    }
}
