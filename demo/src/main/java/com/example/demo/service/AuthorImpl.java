package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorImpl implements AuthorServ {

    private final Author author;
    private final Book book;

    public AuthorImpl(Author author, Book book) {
        this.author = author;
        this.book = book;
    }


    @Override
    public Author saveDepartment(Author department) {
        return null;
    }

    @Override
    public Author findByCC(String cc) {
        return null;
    }

    @Override
    public List<Author> fetchDepartmentList() {
        return null;
    }

    @Override
    public Author updateDepartment(Author department, Integer departmentId) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Integer departmentId) {

    }
}
