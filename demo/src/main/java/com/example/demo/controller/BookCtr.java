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
    public ResponseEntity<String> postBook(@RequestBody Book book){
        Optional<Book> optionalBook = bookImp.saveBook(book, book.getAuthorIdFk().getAuthorId());
        if(optionalBook.isPresent()) {
            return new ResponseEntity<>("OBJECT CREATED!", HttpStatus.OK);
        }
        return new ResponseEntity<>("OBJECT NOT CREATED!", HttpStatus.CONFLICT);
    }

    @PatchMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> patchBook(@PathVariable Integer id, @RequestBody Book book) {
        Optional<Book> bookImpById = bookImp.findById(id);
        return bookImpById.map(value -> ResponseEntity.ok(bookImp.patchBook(value.getBookId(), book)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/book/{id}")
    public @ResponseBody ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        Optional<Book> optionalBook = bookImp.deleteBookById(id);
        if(optionalBook.isPresent()) {
            return new ResponseEntity<>("DELETE Response", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete operation could not be performed successfully", HttpStatus.OK);
    }

    @GetMapping("/book/")
    public ResponseEntity<Iterable<Book>> getAllBook() {
        Optional<Iterable<Book>> bookIterable = bookImp.findAllBookSWithAuthors();
        return bookIterable.map(books -> new ResponseEntity<>(books, HttpStatus.OK)).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

}
