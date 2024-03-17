package com.example.demo.model.author;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
@Data
@NoArgsConstructor
@ToString
@Embeddable
public class AuthorCc {
    private Integer authorCCM;

    public AuthorCc(Integer authorCCM) {
        Objects.requireNonNull(authorCCM, "CC can not be null");
        this.authorCCM = authorCCM;
    }
}
