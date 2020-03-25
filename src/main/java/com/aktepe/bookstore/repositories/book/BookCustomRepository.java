package com.aktepe.bookstore.repositories.book;

import com.aktepe.bookstore.entities.Author;
import com.aktepe.bookstore.entities.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookCustomRepository {
    void saveWithAuthors(Book book);
}
