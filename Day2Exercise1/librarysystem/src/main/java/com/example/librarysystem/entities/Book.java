package com.example.librarysystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private Date publicationDate;
    private String status;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "genre_Id", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "author_Id", nullable = false)
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Reservation> reservations;


    public Book(String title, Date publicationDate, String status, Genre genre, Author author) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.status = status;
        this.isAvailable = false;
        this.genre = genre;
        this.author = author;
    }
}
