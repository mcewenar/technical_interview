package com.example.demo.model.author;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
public class AuthorCc {
    private Integer value;

    public AuthorCc(Integer value) {
        Objects.requireNonNull(value, "CC can not be null");
        this.value = value;
    }
}
