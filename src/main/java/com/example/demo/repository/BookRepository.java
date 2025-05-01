package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

import jakarta.persistence.EntityManager;


/**
 * @author ankit 
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByBookName(String bookName);
    void deleteByBookName(String bookName);
    void deleteByBookId(int bookId);
}

