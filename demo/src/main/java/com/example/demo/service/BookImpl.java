package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImpl implements BookServ {

    @Override
    public Book saveDepartment(Book department) {
        return null;
    }

    @Override
    public List<Book> fetchDepartmentList() {
        return null;
    }

    @Override
    public Book findById(String isbn) {
        return null;
    }

    @Override
    public Book updateDepartment(Author department, Integer departmentId) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Integer departmentId) {

    }
}
