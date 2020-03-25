package com.aktepe.bookstore.repositories.book;

import com.aktepe.bookstore.entities.Author;
import com.aktepe.bookstore.entities.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveWithAuthors(Book book) {
        List<Integer> authorIds = entityManager.createQuery("select id from Author").getResultList();
        if (!authorIds.contains(book.getAuthor().getId())) {
            book.getAuthor().setId(0);
            entityManager.persist(book.getAuthor());
        }
        entityManager.merge(book);
    }
}
