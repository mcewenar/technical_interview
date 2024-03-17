package com.example.demo.service;

import com.example.demo.model.author.Author;
import com.example.demo.repository.AuthorRep;
import com.example.demo.repository.BookRep;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorImpl implements AuthorServ {

    private final AuthorRep authorRep;
    private final BookRep bookRep;

    public AuthorImpl(AuthorRep authorRep, BookRep bookRep) {
        this.authorRep = authorRep;
        this.bookRep = bookRep;
    }


    @Override
    public Author saveAuthor(Author author) {
        Author authorExist = authorRep.findAuthorByAuthorCcmParam(author.getAuthorCc().getAuthorCCM());
        if(authorExist.getAuthorCc().equals(author.getAuthorCc())) {
            throw new IllegalArgumentException(String.format("The cc %s is already created", author.getAuthorCc()));
        }
        return this.authorRep.save(author);
    }

    @Override
    public Optional<Author> findByCC(Integer cc) {
        return Optional.ofNullable(authorRep.findById(cc).orElseThrow(() ->
                new NoSuchElementException(String.format("Id %s not found", cc))));
    }


    @Override
    public void deleteAuthorById(Integer cc) {
        authorRep.deleteById(cc);

    }
}
