package com.example.demo.model.book;

import com.example.demo.model.author.Author;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;

@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name="book")
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer book_id;


    @JdbcTypeCode(SqlTypes.JSON)
    private Isbn isbn;

    @JdbcTypeCode(SqlTypes.JSON)
    private Type type;

    @OneToMany(mappedBy="fk_book")
    private ArrayList<Author> authorArrayList;

    @JdbcTypeCode(SqlTypes.JSON)
    private PageNumber pageNumber;

    @JdbcTypeCode(SqlTypes.JSON)
    private Name name;

    private Book() {}

    public Book(Integer book_id, Isbn isbn, Type type, ArrayList<Author> author, PageNumber pageNumber, Name name) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.type = type;
        this.authorArrayList = author;
        this.pageNumber = pageNumber;
        this.name = name;
    }


    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
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

    public ArrayList<Author> getAuthorArrayList() {
        return authorArrayList;
    }

    public void setAuthorArrayList(ArrayList<Author> authorArrayList) {
        this.authorArrayList = authorArrayList;
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
