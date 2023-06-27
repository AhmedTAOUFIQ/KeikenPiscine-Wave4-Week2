package com.example.librarysystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    private String genreName;
    private String Description;
    @OneToMany(mappedBy = "genre")
    private List<Book> books;

    public Genre(String genreName, String description) {
        this.genreName = genreName;
        Description = description;
    }
}
