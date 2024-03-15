package com.example.demo.model.book;

import com.example.demo.model.author.Author;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name="book")
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer bookId;

    @Embedded
    @Column(name="isbn",insertable=false, updatable=false)
    private Isbn isbn;

    @Embedded
    @Column(name="type",insertable=false, updatable=false)
    private Type type;

    @OneToMany
    private List<Author> authors = new LinkedList<>();


    @Embedded
    @Column(name="page_number",insertable=false, updatable=false)
    private PageNumber pageNumber;

    @Embedded
    @Column(name="name",insertable=false, updatable=false)
    private Name name;


    private Book() {}

    public Book(Integer bookId, Isbn isbn, Type type, List<Author> author, PageNumber pageNumber, Name name) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.type = type;
        this.authors = author;
        this.pageNumber = pageNumber;
        this.name = name;
    }


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public void setIsbn(Isbn isbn) {
        this.isbn = isbn;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public PageNumber getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(PageNumber pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
