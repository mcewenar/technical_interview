package com.example.demo.service;

import com.example.demo.model.book.Book;

import java.util.Optional;

public interface BookServ {
    Book saveBook(Book book);

    Optional<Book> findById(Integer isbn);

    void deleteBookById(Integer isbn);
}
