package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
@ToString
@EqualsAndHashCode
@Entity
@Builder
public class Author {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Id
    private Integer cc;
    private LocalDate birthday;
    private Integer yearOld;


    public Author() {

    }
    public Author(Integer id, String name, Integer cc, LocalDate birthday, Integer yearOld) {
        this.id = id;
        this.name = name;
        this.cc = cc;
        this.birthday = birthday;
        this.yearOld = yearOld;
    }
}
