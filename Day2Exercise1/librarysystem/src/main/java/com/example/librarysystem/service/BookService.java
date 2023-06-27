package com.example.librarysystem.service;

import com.example.librarysystem.entities.Book;
import com.example.librarysystem.repositories.AuthorRepository;
import com.example.librarysystem.repositories.BookRepository;
import com.example.librarysystem.repositories.GenreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@NoArgsConstructor
@Data
public class BookService {
    private BookRepository bookRepository;
    private GenreRepository categoryRepository;
    private AuthorRepository authorRepository;
    @Autowired
    public BookService(BookRepository bookRepository, GenreRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book of ID :  " + id + "not found."));
        return book;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void setBookAvailable(Long id) {
        Book book= getBookById(id);
        book.setAvailable(true);
        bookRepository.save(book);
    }
}