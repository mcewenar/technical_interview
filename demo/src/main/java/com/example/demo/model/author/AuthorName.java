package com.example.demo.model.author;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@NoArgsConstructor
@Embeddable
public class AuthorName {

    private String authorNameAuthor;

    public AuthorName(String authorNameAuthor) {
        Objects.requireNonNull(authorNameAuthor, "AuthorName can not be null");
        this.authorNameAuthor = authorNameAuthor;
    }
}
