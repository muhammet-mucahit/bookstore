package com.aktepe.bookstore.repositories.book;

import com.aktepe.bookstore.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>, BookCustomRepository {
    List<Book> findByNameContainingIgnoreCase(String searchText);
}
