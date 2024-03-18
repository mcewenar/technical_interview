package com.example.demo.service;

import com.example.demo.model.author.Author;
import com.example.demo.model.book.AuthorIdFk;
import com.example.demo.model.book.Book;
import com.example.demo.repository.AuthorRep;
import com.example.demo.repository.BookRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookImpl implements BookServ {

    private final AuthorRep authorRep;
    private final BookRep bookRep;

    public BookImpl(AuthorRep authorRep, BookRep bookRep) {
        this.authorRep = authorRep;
        this.bookRep = bookRep;
    }

    @Override
    public Optional<Book> saveBook(Book book, Integer idAuthor) {
        Optional<Author> optionalAuthor = authorRep.findById(idAuthor);
        Optional<Book> bookExist = Optional.ofNullable(bookRep.findBookByIsbnParam(book.getIsbn().getIsbnBook()));
        if(optionalAuthor.isEmpty()) {
            log.error(String.format("The author with ID %s not found", idAuthor));
            return Optional.empty();
        }
        if(bookExist.isPresent()) {
            log.error(String.format("The cc ID %s is already created", book.getIsbn().getIsbnBook()));
            return Optional.empty();
        }
        book.setAuthorIdFk(new AuthorIdFk(idAuthor));
        return Optional.ofNullable(this.bookRep.save(book));
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
    public Optional<Iterable<Book>> findAllBookSWithAuthors() {
        Optional<Iterable<Book>> bookExist = bookRep.findAllBookWithAuthor();
        if(bookExist.isEmpty()) {
            log.error("NOT FOUND BOOKS WITH AUTHORS");
            return Optional.empty();
        }
        return bookRep.findAllBookWithAuthor();
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
