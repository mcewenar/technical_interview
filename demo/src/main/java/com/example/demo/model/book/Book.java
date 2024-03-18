package com.example.demo.model.book;

import com.example.demo.model.author.Author;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;

    @Embedded
    @Column(name="isbn",insertable=false, updatable=false, unique = true)
    private Isbn isbn;

    @Embedded
    @Column(name="type",insertable=false, updatable=false)
    private Type type;

    @Embedded
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;


    @Embedded
    @Column(name="page_number",insertable=false, updatable=true)
    private PageNumber pageNumber;

    @Embedded
    @Column(name="name",insertable=false, updatable=false)
    private Name name;


    private Book() {}

    public Book(Integer bookId, Isbn isbn, Type type, Author author, PageNumber pageNumber, Name name) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.type = type;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
