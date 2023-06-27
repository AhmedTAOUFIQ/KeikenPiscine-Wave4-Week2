package com.example.librarysystem;

import com.example.librarysystem.entities.Author;
import com.example.librarysystem.entities.Book;
import com.example.librarysystem.entities.Genre;
import com.example.librarysystem.repositories.AuthorRepository;
import com.example.librarysystem.repositories.GenreRepository;
import com.example.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
class MyCommandLineRunner implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookService bookService;

    @Autowired
    public MyCommandLineRunner(AuthorRepository authorRepository, GenreRepository genreRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) {
        Genre genre1 = new Genre("Historical Fiction", "Blend of fiction and history, transporting readers to the past.");
        Genre genre2 = new Genre("Fantasy", "Magical worlds, mythical creatures, and epic quests");
        genreRepository.save(genre1);
        genreRepository.save(genre2);

        Author author1 = new Author("First Author", new Date(1966, 6, 7), "French", "This is a sample biography for the first author");
        Author author2 = new Author("Second Author", new Date(1942, 4, 3), "Moroccan", "This is a sample biography for the second author");
        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book1 = new Book("Title1", new Date(2010, 5, 12), "UpComing", genre1, author1);
        Book book2 = new Book("Title2", new Date(2002, 7, 8), "UpComing", genre2, author2);
        bookService.addBook(book1);
        bookService.addBook(book2);
    }
}