package com.first.api.entity.model;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

   

    public String geteMail() {
        return email;
    }


    public void seteMail(String eMail) {
        this.email = eMail;
    }

    
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
   
}