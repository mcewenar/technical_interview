package com.example.demo.controller;

import com.example.demo.service.AuthorImpl;
import com.example.demo.service.BookImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iastest")
public class BookCtr {

    private final BookImpl bookImp;
    private final AuthorImpl authorImp;

    public BookCtr(BookImpl bookImp, AuthorImpl authorImp) {
        this.bookImp = bookImp;
        this.authorImp = authorImp;
    }

    @GetMapping("/book/{id}")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
