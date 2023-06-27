package com.example.librarysystem.repositories;

import com.example.librarysystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
