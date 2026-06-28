package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository SetterRepo;
    private BookRepository ConstructorRepo;
    private BookService(BookRepository ConstructorRepo){
        this.ConstructorRepo = ConstructorRepo;
        System.out.println("Constructor Injection Executed");
    }
    @Autowired
    public void setBookRepository(BookRepository SetterRepo) {
        this.SetterRepo = SetterRepo;
        System.out.println("Setter method Injection Executed");
    }
    public void issueBook() {
        System.out.println("BookService: Issuing Book...");
        System.out.println("Calling Constructor.....................");
        ConstructorRepo.displayBook();
        System.out.println(("Calling Setter method.................."));
        SetterRepo.displayBook();

    }
}