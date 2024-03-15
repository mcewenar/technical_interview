package com.example.demo.model.author;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class BirthDate {
    private LocalDate birthDateAuthor;

    public BirthDate(LocalDate birthDateAuthor) {
        Objects.requireNonNull(birthDateAuthor, "BirthDate can not be null");
        this.birthDateAuthor = birthDateAuthor;
    }

}
