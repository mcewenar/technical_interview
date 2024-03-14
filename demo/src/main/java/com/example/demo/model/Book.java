package com.example.demo.model;

import com.example.demo.model.Author;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "author")
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Id
    private String isbn;

    private String type;

    private ArrayList<Author> authorArrayList;

    private Integer pageNumber;

    private String name;

    private Book() {}

    public Book(Integer id, String isbn, String type, ArrayList<Author> author, Integer pageNumber, String name) {
        this.id = id;
        this.isbn = isbn;
        this.type = type;
        this.authorArrayList = author;
        this.pageNumber = pageNumber;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Author> getAuthorArrayList() {
        return authorArrayList;
    }

    public void setAuthorArrayList(ArrayList<Author> authorArrayList) {
        this.authorArrayList = authorArrayList;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
