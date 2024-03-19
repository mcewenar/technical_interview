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
    @Column(name="id",insertable=false, updatable=false)
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "authorId")
    private Integer id;

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
    public Author(Integer id, AuthorName authorName, AuthorCc authorCc, LocalDate birthday, YearsOld yearOld) {
        this.id = id;
        this.authorName = authorName;
        this.authorCc = authorCc;
        this.birthday = birthday;
        this.yearOld = yearOld;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
