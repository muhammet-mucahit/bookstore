package com.aktepe.bookstore.services;

import com.aktepe.bookstore.entities.Book;
import com.aktepe.bookstore.repositories.author.AuthorRepository;
import com.aktepe.bookstore.repositories.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    // @Autowired annotation provides the automatic dependency injection.
    private final BookRepository repository;
    private final AuthorRepository authorRepo;

    @Autowired
    public BookService(BookRepository repository, AuthorRepository authorRepo) {
        this.repository = repository;
        this.authorRepo = authorRepo;
    }

    // Save student entity in the h2 database.
    public void save(final Book book) {
//        book.getAuthors().forEach(a -> {
//            if (!authorRepo.existsById(a.getId())) {
//                authorRepo.save(a);
//            }
//        });
        repository.saveWithAuthors(book);
    }

    // Get all students from the h2 database.
    public List<Book> getAll() {
        final List<Book> books = new ArrayList<>();
        repository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public List<Book> search(final String searchText) {
        return repository.findByNameContainingIgnoreCase(searchText);
    }
}
