package com.example.demo.model.book;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class Name {
    private String nameBook;

    public Name(String nameBook) {
        Objects.requireNonNull(nameBook, "Name can not be null");
        this.nameBook = nameBook;
    }
}
