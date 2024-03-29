package com.example.demo.service;

import com.example.demo.model.author.Author;

import java.time.LocalDate;
import java.util.Optional;

public interface AuthorServ {
    Optional<Author> saveAuthor(Author author);

    Optional<Author> findById(Integer id);

    Optional<Author> deleteAuthorById(Integer cc);

    Integer calculateYearsOld(LocalDate dateAuthor);

    Optional<Author> patchAuthor(Integer id, Author author);

    Iterable<Author> findAllAuthorS();
}
