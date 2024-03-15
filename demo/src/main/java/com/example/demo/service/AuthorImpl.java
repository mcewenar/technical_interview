package com.example.demo.service;

import com.example.demo.model.author.Author;
import com.example.demo.repository.AuthorRep;
import com.example.demo.repository.BookRep;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorImpl implements AuthorServ {

    private final AuthorRep author;
    private final BookRep book;

    public AuthorImpl(AuthorRep author, BookRep book) {
        this.author = author;
        this.book = book;
    }


    @Override
    public Author saveAuthor(Author author) {
        return this.author.save(author);
    }

    @Override
    public Optional<Author> findByCC(Integer cc) {
        return Optional.ofNullable(author.findById(cc).orElseThrow(NullPointerException::new));
    }

    /*@Override
    public Author updateAuthorByCC(Author author) {
        return this.author.updateAuthor(author.getCc().toString());
    }

     */


    @Override
    public void deleteAuthorById(Integer cc) {
        author.deleteById(cc);

    }
}
