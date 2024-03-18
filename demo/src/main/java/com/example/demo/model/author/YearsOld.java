package com.example.demo.model.author;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class YearsOld {
    private Integer yearOldAuthor;

    public YearsOld(Integer yearOldAuthor) {
        Objects.requireNonNull(yearOldAuthor, "YearsOld can not be null");
        this.yearOldAuthor = yearOldAuthor;
    }
}
