package com.example.demo.service;

import com.example.demo.model.book.Book;
import com.example.demo.repository.AuthorRep;
import com.example.demo.repository.BookRep;
import org.springframework.stereotype.Service;

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
        Optional<Book> bookExist = Optional.ofNullable(bookRep.findBookByIsbnParam(book.getIsbn().getIsbnBook()));
        if(bookExist.isPresent()) {
            throw new IllegalArgumentException(String.format("The Isbn %s is already created", book.getIsbn().getIsbnBook().toString()));
        }
        return this.bookRep.save(book);
    }

    @Override
    public Optional<Book> findById(Integer isbn) {
        return bookRep.findById(isbn);
    }

    @Override
    public Optional<Book> patchBook(Integer id, Book book) {
        Optional<Book> optionalBookFind = bookRep.findById(id);
        optionalBookFind.ifPresent(value -> value.setPageNumber(book.getPageNumber()));
        return Optional.ofNullable(bookRep.save(optionalBookFind.get()));
    }

    @Override
    public Iterable<Book> findAllBookS() {
        return bookRep.findAllBook();
    }

    @Override
    public Book insertForeignKey() {
        return null;
    }

    @Override
    public Optional<Book> deleteBookById(Integer id) {
        Optional<Book> optionalBook = findById(id);
        if(optionalBook.isPresent()) {
            bookRep.deleteById(id);
            return optionalBook;
        }
        return Optional.empty();
    }
}
