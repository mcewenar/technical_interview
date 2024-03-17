package com.example.demo.service;

import com.example.demo.model.author.Author;

import java.time.LocalDate;
import java.util.Optional;

public interface AuthorServ {
    Author saveAuthor(Author author);

    Optional<Author> findByCC(Integer cc);

    void deleteAuthorById(Integer cc);

    Integer calculateYearsOld(LocalDate dateAuthor);
}
