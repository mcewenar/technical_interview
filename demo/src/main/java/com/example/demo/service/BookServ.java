package com.example.demo.service;

import com.example.demo.model.book.Book;

import java.util.Optional;

public interface BookServ {
    Book saveBook(Book book);

    Optional<Book> findById(String isbn);

    // Update operation
    Book updateBook(Book book);

    // Delete operation
    void deleteBookById(String isbn);
}
