package com.example.demo.controller;

import com.example.demo.model.author.Author;
import com.example.demo.model.book.Book;
import com.example.demo.service.AuthorImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/iastest")
public class AuthorCtr {
    private final AuthorImpl authorImp;

    public AuthorCtr(AuthorImpl authorImp) {
        this.authorImp = authorImp;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
        Optional<Author> author1 = authorImp.findByCC(id);
        return author1.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/author/")
    public ResponseEntity<Author> postAuthor(@RequestBody Author book){
        Author author1 = authorImp.saveAuthor(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(author1);

    }

    @PatchMapping("/author/{id}")
    public ResponseEntity<Book> patchBook(@PathVariable Integer id, @RequestBody Author author) {
        Optional<Author> authorImpByCC = authorImp.findByCC(id);
        if (authorImpByCC.isPresent()) {
            authorImpByCC.get().setAuthorName(author.getAuthorName());
            return ResponseEntity.ok(authorImp.saveAuthor(authorImpByCC.get()).getFk_book());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/author/{id}")
    public @ResponseBody ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        authorImp.deleteAuthorById(id);
        return new ResponseEntity<>("DELETE Response", HttpStatus.OK);
    }


}

