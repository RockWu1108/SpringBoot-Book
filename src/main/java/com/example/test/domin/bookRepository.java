package com.example.test.domin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface bookRepository extends JpaRepository<Book , Long> {

    List<Book> findByAuthor(String author);
}
