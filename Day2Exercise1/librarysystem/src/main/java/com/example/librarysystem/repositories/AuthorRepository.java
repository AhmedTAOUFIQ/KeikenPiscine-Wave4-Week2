package com.example.librarysystem.repositories;

import com.example.librarysystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
