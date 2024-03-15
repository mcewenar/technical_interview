package com.example.demo.model.author;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class YearsOld {
    private Integer yeardOldAuthor;

    public YearsOld(Integer yeardOldAuthor) {
        Objects.requireNonNull(yeardOldAuthor, "YearsOld can not be null");
        this.yeardOldAuthor = yeardOldAuthor;
    }
}
