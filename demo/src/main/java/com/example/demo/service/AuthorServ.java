package com.example.demo.service;

import com.example.demo.model.author.Author;

import java.util.Optional;

public interface AuthorServ {
    Author saveAuthor(Author author);

    Optional<Author> findByCC(Integer cc);

    //update
    //Author updateAuthorByCC(Author author);


    // Delete operation
    void deleteAuthorById(Integer cc);
}
