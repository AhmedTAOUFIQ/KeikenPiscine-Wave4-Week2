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
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String AuthorName;
    private Date BirthDate;
    private String Nationality;
    private String Biography;
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String authorName, Date birthDate, String nationality, String biography) {
        AuthorName = authorName;
        BirthDate = birthDate;
        Nationality = nationality;
        Biography = biography;
    }
}
