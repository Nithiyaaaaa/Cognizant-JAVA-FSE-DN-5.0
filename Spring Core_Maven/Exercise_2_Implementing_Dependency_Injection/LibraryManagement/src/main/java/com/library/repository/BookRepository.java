package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void displayBook() {
        System.out.println("BookRepository");
    }
}