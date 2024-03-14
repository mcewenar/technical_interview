package com.example.demo.service;

import com.example.demo.model.Author;

import java.util.List;

public interface AuthorServ {
    Author saveDepartment(Author department);

    Author findByCC(String cc);

    // Read operation
    List<Author> fetchDepartmentList();

    // Update operation
    Author updateDepartment(Author department,
                                Integer departmentId);

    // Delete operation
    void deleteDepartmentById(Integer departmentId);
}
