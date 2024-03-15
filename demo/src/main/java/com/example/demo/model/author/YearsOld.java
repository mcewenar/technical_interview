package com.example.demo.model.author;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class YearsOld {
    private Integer value;

    public YearsOld(Integer value) {
        Objects.requireNonNull(value, "YearsOld can not be null");
        this.value = value;
    }
}
