package com.example.demo.repository;

import com.example.demo.model.author.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRep extends CrudRepository<Author, Integer> {

    Optional<Author> findById(Integer id);

    void deleteById(Integer id);

    Author save(Author book);

    @Query(value ="SELECT * FROM author a WHERE a.authorccm = :cc",nativeQuery=true)
    Author findAuthorByAuthorCcmParam(@Param("cc") Long cc);

    @Query(value ="SELECT * FROM author a ORDER BY a.id ASC LIMIT 10 OFFSET 0;",nativeQuery=true)
    Iterable<Author> findAllAuthor();
}
