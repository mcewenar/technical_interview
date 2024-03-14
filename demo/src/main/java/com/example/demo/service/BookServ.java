package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;

import java.util.List;

public interface BookServ {
    Book saveDepartment(Book department);

    // Read operation
    List<Book> fetchDepartmentList();

    Book findById(String isbn);

    // Update operation
    Book updateDepartment(Author department, Integer departmentId);

    // Delete operation
    void deleteDepartmentById(Integer departmentId);
}
