package com.example.demo.service;

import com.example.demo.model.book.Book;

import java.util.Optional;

public interface BookServ {
    Optional<Book> saveBook(Book book, Integer id);

    Optional<Book> findById(Integer isbn);

    Optional<Book> deleteBookById(Integer isbn);

    Optional<Book> patchBook(Integer id, Book book);

    Optional<Iterable<Book>> findAllBookSWithAuthors();
}
