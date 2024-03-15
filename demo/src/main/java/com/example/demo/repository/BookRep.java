package com.example.demo.repository;

import com.example.demo.model.book.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRep extends CrudRepository<Book,Integer> {
    Optional<Book> findById(String id);

    void deleteById(Integer id);

    Book save(Book book);

    @Modifying
    @Query("UPDATE book b set b.book_id = :book_id b.type b.pageNumber b.name WHERE b.book_id = :book_id")
    Book updatePhone(@Param(value = "isbn") Integer isbn, @Param(value = "type") String type);
}
