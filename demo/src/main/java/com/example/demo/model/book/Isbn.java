package com.example.demo.model.book;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@ToString
@Data
@NoArgsConstructor
@Embeddable
public class Isbn {
    private String isbnBook;

    public Isbn(String isbnBook) {
        Objects.requireNonNull(isbnBook, "Book ISBN can not be null");
        this.isbnBook = isbnBook;
    }
}
