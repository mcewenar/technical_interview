package com.example.demo.service;

import com.example.demo.model.book.Book;
import com.example.demo.repository.AuthorRep;
import com.example.demo.repository.BookRep;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookImpl implements BookServ {

    private final AuthorRep authorRep;
    private final BookRep bookRep;

    public BookImpl(AuthorRep authorRep, BookRep bookRep) {
        this.authorRep = authorRep;
        this.bookRep = bookRep;
    }

    @Override
    public Book saveBook(Book book) {
        Book bookExist = bookRep.findBookByIsbnParam(book.getIsbn().getIsbnBook());
        if(bookExist.getIsbn().equals(book.getIsbn())) {
            throw new IllegalArgumentException(String.format("The Isbn %s is already created", book.getIsbn()));
        }
        return this.bookRep.save(book);
    }

    @Override
    public Optional<Book> findById(Integer isbn) {
        return Optional.ofNullable(bookRep.findById(isbn).orElseThrow(() ->
                new NoSuchElementException(String.format("Id %s not found", isbn))));

    }

    @Override
    public void deleteBookById(Integer isbn) {
        bookRep.deleteById(isbn);

    }
}
