package main.java.com.lms.lib.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String category;
    private int availableCopies;

    public Book() {}
    public Book(Long id, String title, String author, String category, int availableCopies) {
        this.id = id; this.title = title; this.author = author; this.category = category; this.availableCopies = availableCopies;
    }
    // Getters and setters ...
}
