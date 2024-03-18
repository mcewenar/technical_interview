package com.example.demo.model.author;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@ToString
@EqualsAndHashCode
@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="author_id",insertable=false, updatable=false)
    private Integer authorId;

    @Embedded
    @Column(name="author_name",insertable=false, updatable=false)
    private AuthorName authorName;

    @Embedded
    @Column(name="cc",insertable=false, updatable=false, unique = true)
    private AuthorCc authorCc;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name="birth_day",insertable=true, updatable=true)
    //@Embedded
    //private BirthDay birthDay;
    private LocalDate birthday;

    @Embedded
    @Column(name="year_old",insertable=false, updatable=false)
    private YearsOld yearOld;

    public Author() {}
    public Author(Integer authorId, AuthorName authorName, AuthorCc authorCc, LocalDate birthday, YearsOld yearOld) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorCc = authorCc;
        this.birthday = birthday;
        this.yearOld = yearOld;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public YearsOld getYearOld() {
        return yearOld;
    }

    public void setYearOld(YearsOld yearOld) {
        this.yearOld = yearOld;
    }
}
