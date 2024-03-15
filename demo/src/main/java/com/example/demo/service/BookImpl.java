package com.example.demo.service;

import com.example.demo.model.book.Book;
import com.example.demo.repository.AuthorRep;
import com.example.demo.repository.BookRep;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookImpl implements BookServ {

    private final AuthorRep author;
    private final BookRep book;

    public BookImpl(AuthorRep author, BookRep book) {
        this.author = author;
        this.book = book;
    }

    @Override
    public Book saveBook(Book book) {
        return this.book.save(book);
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(book.findById(isbn).orElseThrow(NullPointerException::new));

    }

    @Override
    public Book updateBook(Book book) {
        return this.book.updatePhone(book.getBook_id(),book.getType().toString());
    }

    @Override
    public void deleteBookById(String isbn) {

    }
}
