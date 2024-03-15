package com.example.demo.model.book;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class PageNumber {
    private Integer pageNumberBook;

    public PageNumber(Integer pageNumberBook) {
        Objects.requireNonNull(pageNumberBook, "Page number can not be null");
        this.pageNumberBook = pageNumberBook;
    }
}
