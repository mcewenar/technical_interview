package com.example.demo.model.book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class PageNumber {
    private Integer value;

    public PageNumber(Integer value) {
        Objects.requireNonNull(value, "Page number can not be null");
        this.value = value;
    }
}
