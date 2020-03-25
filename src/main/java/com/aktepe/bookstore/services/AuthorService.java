package com.aktepe.bookstore.services;

import com.aktepe.bookstore.entities.Author;
import com.aktepe.bookstore.repositories.author.AuthorRepository;
import com.aktepe.bookstore.repositories.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    // @Autowired annotation provides the automatic dependency injection.
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorService(AuthorRepository repository, BookRepository bookRepository) {
        this.authorRepository = repository;
        this.bookRepository = bookRepository;
    }

    // Get all students from the h2 database.
    public List<Author> getAll() {
        final List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(author -> authors.add(author));
        return authors;
    }

    public void delete(int authorId) {
        bookRepository.findAll().forEach(b -> {
            if (b.getAuthor().getId() == authorId) bookRepository.delete(b);
        });
    }
}
