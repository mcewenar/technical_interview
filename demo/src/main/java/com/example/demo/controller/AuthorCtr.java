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
    private final AuthorImpl authorImp;

    public AuthorCtr(AuthorImpl authorImp) {
        this.authorImp = authorImp;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
        Optional<Author> author1 = authorImp.findById(id);
        return author1.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/author/")
    public ResponseEntity<String> postAuthor(@RequestBody Author author){
        Optional<Author> optionalAuthor = authorImp.saveAuthor(author);
        if(optionalAuthor.isPresent()) {
            return new ResponseEntity<>(String.format("OBJECT WITH CC %s was created!",author.getAuthorCc().getAuthorCCM())
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(String.format("OBJECT WITH CC %s wasn't created!",author.getAuthorCc().getAuthorCCM()), HttpStatus.CONFLICT);

    }

    @PatchMapping("/author/{id}")
    public ResponseEntity<Author> patchBook(@PathVariable Integer id, @RequestBody Author author) {
        Optional<Author> authorImpByCC = authorImp.findById(id);
        return authorImpByCC.map(value -> ResponseEntity.ok(authorImp.patchAuthor(value.getId(), author).get()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/author/{id}")
    public @ResponseBody ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        Optional<Author> optionalAuthor = authorImp.deleteAuthorById(id);
        if(optionalAuthor.isPresent()) {
            return new ResponseEntity<>(String.format("The ID %s was deleted successfully",id), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/author/")
    public ResponseEntity<Iterable<Author>> getAllAuthor() {
        Optional<Iterable<Author>> authorIterable = Optional.ofNullable(authorImp.findAllAuthorS());
        return authorIterable.map(authors -> new ResponseEntity<>(authors, HttpStatus.OK)).
                orElseGet(() -> ResponseEntity.notFound().build());
    }
}

