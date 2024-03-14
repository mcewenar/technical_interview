package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;

@RestController
@RequestMapping("/iastest")
public class AuthorCtr {
    private final AuthorImpl author;

    public AuthorCtr(AuthorImpl author) {
        this.author = author;
    }

    @GetMapping("/author/{id}")
    public @ResponseBody Author getById(@PathVariable String id) {

        return author.findByCC(id);
    }
    @PostMapping
    public ResponseEntity<String> postAuthor(){
        return new ResponseEntity<String>("POST Response", HttpStatus.OK);
    }


    @PutMapping("/author/{id}")
    public @ResponseBody ResponseEntity<String> put(@PathVariable String id) {
        return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable String id) {
        return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
    }
}

