package com.example.demo.model.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@NoArgsConstructor
public class AuthorName {

    private String value;

    public AuthorName(String value) {
        Objects.requireNonNull(value, "AuthorName can not be null");
        this.value = value;
    }
}
