package com.example.demo.model.author;

import com.example.demo.model.book.Book;
import jakarta.persistence.*;
import lombok.*;


@ToString
@EqualsAndHashCode
@Entity
@Table(name="author")
public class Author {

    @ManyToOne(optional=false)
    @JoinColumn(name="book_id", nullable=true)
    private Book fk_book;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="author_id",insertable=false, updatable=false)
    private Integer authorId;

    @Embedded
    @Column(name="author_name",insertable=false, updatable=false)
    private AuthorName authorName;

    @Embedded
    @Column(name="cc",insertable=false, updatable=false)
    private AuthorCc authorCc;

    @Embedded
    @Column(name="birth_day",insertable=false, updatable=false)
    private BirthDate birthday;

    @Embedded
    @Column(name="year_old",insertable=false, updatable=false)
    private YearsOld yearOld;

    public Author() {}
    public Author(Integer authorId, AuthorName authorName, AuthorCc authorCc, BirthDate birthday, YearsOld yearOld) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorCc = authorCc;
        this.birthday = birthday;
        this.yearOld = yearOld;
    }

    public Book getFk_book() {
        return fk_book;
    }

    public void setFk_book(Book fk_book) {
        this.fk_book = fk_book;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public AuthorName getAuthorName() {
        return authorName;
    }

    public void setAuthorName(AuthorName authorName) {
        this.authorName = authorName;
    }

    public AuthorCc getAuthorCc() {
        return authorCc;
    }

    public void setAuthorCc(AuthorCc authorCc) {
        this.authorCc = authorCc;
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
