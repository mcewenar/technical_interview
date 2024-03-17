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

    @Query(value ="SELECT a FROM AUTHOR a WHERE a.AUTHORCCM = :cc",nativeQuery=true)
    Author findAuthorByAuthorCcmParam(@Param("cc") Integer cc);



    void deleteById(Integer id);

    Author save(Author book);

}
