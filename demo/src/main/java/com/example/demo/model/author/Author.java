package com.example.demo.model.author;

import com.example.demo.model.book.Book;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@ToString
@EqualsAndHashCode
@Entity
@Table(name="author")
public class Author {

    @ManyToOne
    @JoinColumn(name="book_id", nullable=true)
    private Book fk_book;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @JdbcTypeCode(SqlTypes.JSON)
    private AuthorName name;
    @JdbcTypeCode(SqlTypes.JSON)
    private AuthorCc cc;
    @JdbcTypeCode(SqlTypes.JSON)
    private BirthDate birthday;
    @JdbcTypeCode(SqlTypes.JSON)
    private YearsOld yearOld;


    public Author() {}
    public Author(Integer id, AuthorName name, AuthorCc cc, BirthDate birthday, YearsOld yearOld) {
        this.id = id;
        this.name = name;
        this.cc = cc;
        this.birthday = birthday;
        this.yearOld = yearOld;
    }

    public Book getFk_book() {
        return fk_book;
    }

    public void setFk_book(Book fk_book) {
        this.fk_book = fk_book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorName getName() {
        return name;
    }

    public void setName(AuthorName name) {
        this.name = name;
    }

    public AuthorCc getCc() {
        return cc;
    }

    public void setCc(AuthorCc cc) {
        this.cc = cc;
    }

    public BirthDate getBirthday() {
        return birthday;
    }

    public void setBirthday(BirthDate birthday) {
        this.birthday = birthday;
    }

    public YearsOld getYearOld() {
        return yearOld;
    }

    public void setYearOld(YearsOld yearOld) {
        this.yearOld = yearOld;
    }
}
