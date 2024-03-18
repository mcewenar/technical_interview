package com.example.demo.repository;

import com.example.demo.model.book.Book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRep extends CrudRepository<Book,Integer> {
    Optional<Book> findById(Integer id);

    void deleteById(Integer id);

    Book save(Book book);

    @Query(value = "SELECT * FROM book b WHERE b.ISBN_BOOK = :isbn",nativeQuery=true)
    Book findBookByIsbnParam(@Param("isbn") String isbn);

    @Query(value ="SELECT * FROM book a ORDER BY a.book_id ASC LIMIT 10 OFFSET 0;",nativeQuery=true)
    Iterable<Book> findAllBook();

}
