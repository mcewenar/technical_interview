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

    @Query(value = "SELECT b.book_id, b.page_number_book, b.type_book, a.author_name_author, " +
            "b.name_book, b.isbn_book, a.year_old_author FROM author a " +
            "INNER JOIN book b ON a.id = b.author_id ORDER BY b.name_book ASC LIMIT 10 OFFSET 0",nativeQuery = true)
    Optional<Iterable<Book>> findAllBookWithAuthor();


}
