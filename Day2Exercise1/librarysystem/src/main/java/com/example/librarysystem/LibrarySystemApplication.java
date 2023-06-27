package com.example.librarysystem;

import com.example.librarysystem.entities.Author;
import com.example.librarysystem.entities.Book;
import com.example.librarysystem.entities.Genre;
import com.example.librarysystem.repositories.AuthorRepository;
import com.example.librarysystem.repositories.GenreRepository;
import com.example.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.librarysystem")
public class LibrarySystemApplication {
	/*@Autowired
	static GenreRepository genreRepository;
	@Autowired
	static AuthorRepository authorRepository;*/

	public static void main(String[] args) {
		//ApplicationContext context = SpringApplication.run(LibrarySystemApplication.class, args);
		//BookService bookService = (BookService)context.getBean("bookService");
		//GenreRepository genreRepository = (GenreRepository) context.getBean("genreRepository");
		//AuthorRepository authorRepository = (AuthorRepository) context.getBean("authorRepository");
		SpringApplication.run(LibrarySystemApplication.class, args);

		}


}
