package com.example.librarysystem.repositories;

import com.example.librarysystem.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
