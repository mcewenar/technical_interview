package com.example.demo.service;

import com.example.demo.model.author.Author;

import com.example.demo.model.author.YearsOld;

import com.example.demo.repository.AuthorRep;
import com.example.demo.repository.BookRep;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class AuthorImpl implements AuthorServ {

    private final AuthorRep authorRep;
    private final BookRep bookRep;

    public AuthorImpl(AuthorRep authorRep, BookRep bookRep) {
        this.authorRep = authorRep;
        this.bookRep = bookRep;
    }


    @Override
    public Author saveAuthor(Author author) {
        Optional<Author> authorOptional = Optional.ofNullable(authorRep.findAuthorByAuthorCcmParam(author.getAuthorCc().getAuthorCCM()));
        if (authorOptional.isPresent()) {
            throw new IllegalArgumentException(String.format("The cc %s is already created", author.getAuthorCc().getAuthorCCM().toString()));
        }
        author.setYearOld(new YearsOld(calculateYearsOld(author.getBirthday())));
        return this.authorRep.save(author);
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorRep.findById(id);
    }


    @Override
    public Optional<Author> deleteAuthorById(Integer cc) {
       Optional<Author> authorOptional = findById(cc);
       if(authorOptional.isPresent()) {
           authorRep.deleteById(cc);
           return authorOptional;
       }
       return Optional.empty();
    }

    @Override
    public Optional<Author> patchAuthor(Integer id, Author author) {
        Optional<Author> optionalAuthorFind = authorRep.findById(id);
        optionalAuthorFind.ifPresent(value -> value.setAuthorName(author.getAuthorName()));
        return Optional.ofNullable(this.authorRep.save(optionalAuthorFind.get()));
    }

    @Override
    public Iterable<Author> findAllAuthorS() {
        return authorRep.findAllAuthor();
    }

    @Override
    public Integer calculateYearsOld(LocalDate dateAuthor) {
        return Period.between(dateAuthor, LocalDate.now()).getYears();
    }




}
