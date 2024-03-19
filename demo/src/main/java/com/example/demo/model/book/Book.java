package com.example.demo.model.book;

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
    @JoinColumn(name = "id",insertable=true, updatable=true)
    private AuthorIdFk authorIdFk;

    @Embedded
    @Column(name="page_number",insertable=false, updatable=true)
    private PageNumber pageNumber;

    @Embedded
    @Column(name="name",insertable=false, updatable=false)
    private Name name;

    private Book() {}

    public Book(Integer bookId, Isbn isbn, Type type, AuthorIdFk authorIdFk, PageNumber pageNumber, Name name) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.type = type;
        this.authorIdFk = authorIdFk;
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

    public AuthorIdFk getAuthorIdFk() {
        return authorIdFk;
    }

    public void setAuthorIdFk(AuthorIdFk authorIdFk) {
        this.authorIdFk = authorIdFk;
    }
}
