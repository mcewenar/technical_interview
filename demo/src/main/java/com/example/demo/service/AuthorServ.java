package com.example.demo.service;

import com.example.demo.model.author.Author;

import java.util.Optional;

public interface AuthorServ {
    Author saveDepartment(Author author);

    Optional<Author> findByCC(String cc);

    //update
    //Author updateAuthorByCC(Author author);


    // Delete operation
    void deleteDepartmentById(Integer cc);
}
