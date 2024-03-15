package com.example.demo.controller;

import com.example.demo.model.author.Author;
import com.example.demo.service.AuthorImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/iastest")
public class AuthorCtr {
    private final AuthorImpl author;

    public AuthorCtr(AuthorImpl author) {
        this.author = author;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
        Optional<Author> author1 = author.findByCC(id);
        return author1.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/author/")
    public ResponseEntity<Author> postAuthor(@RequestBody Author book){
        Author author1 =author.saveAuthor(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(author1);

    }

/*
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            book.setId(id);
            Book updatedBook = bookRepository.save(book);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/author/{id}")
    public @ResponseBody ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        author.deleteAuthorById(id);
        return new ResponseEntity<>("DELETE Response", HttpStatus.OK);
    }


}

