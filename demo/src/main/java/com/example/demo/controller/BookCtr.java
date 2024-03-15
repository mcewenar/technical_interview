package com.example.demo.controller;

import com.example.demo.model.book.Book;
import com.example.demo.service.BookImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/iastest")
public class BookCtr {

    private final BookImpl bookImp;

    public BookCtr(BookImpl bookImp) {
        this.bookImp = bookImp;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Optional<Book> book1 = bookImp.findById(id);
        return book1.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/book/")
    public ResponseEntity<Book> postBook(@RequestBody Book book){
        Book book1 =bookImp.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book1);

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

    @DeleteMapping("/book/{id}")
    public @ResponseBody ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        bookImp.deleteBookById(id);
        return new ResponseEntity<>("DELETE Response", HttpStatus.OK);
    }

}
