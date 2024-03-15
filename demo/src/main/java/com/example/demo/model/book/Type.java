package com.example.demo.model.book;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class Type {
    private String typeBook;

    public Type(String typeBook) {
        Objects.requireNonNull(typeBook, "Book type can not be null");
        this.typeBook = typeBook;
    }
}
