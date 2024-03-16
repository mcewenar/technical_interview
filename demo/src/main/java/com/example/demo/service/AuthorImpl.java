package com.example.demo.service;

import com.example.demo.model.author.Author;
import com.example.demo.repository.AuthorRep;
import com.example.demo.repository.BookRep;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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
        Optional<Author> authorExist = findByCC(author.getAuthorId());
        if(author.getAuthorCc().equals(authorExist.get().getAuthorCc())) {
            throw new IllegalArgumentException(String.format("Id %s not found", author.getAuthorCc()));
        }
        return this.author.save(author);
    }

    @Override
    public Optional<Author> findByCC(Integer cc) {
        return Optional.ofNullable(author.findById(cc).orElseThrow(() ->
                new NoSuchElementException(String.format("Id %s not found", cc))));
    }


    @Override
    public void deleteAuthorById(Integer cc) {
        author.deleteById(cc);

    }
}
