package com.example.demo.model.book;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class AuthorIdFk {
    private Integer authorId;

    public AuthorIdFk(Integer authorId) {
        Objects.requireNonNull(authorId, "Author ID can not be null");
        this.authorId = authorId;
    }

}
