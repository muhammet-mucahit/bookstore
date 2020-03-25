package com.aktepe.bookstore.controllers;

import com.aktepe.bookstore.entities.Book;
import com.aktepe.bookstore.services.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ApiOperation(value = "Get All Books", notes = "<strong>This endpoint returns all Books in database</strong>")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping(value = "/search")
    @ApiOperation(value = "Search Books By Name", notes = "<strong>This endpoint search all Books through search text in database</strong>")

    public List<Book> search(@RequestParam String query) {
        return bookService.search(query);
    }

    @PostMapping
    @ApiOperation(value = "Add Book", notes = "<strong>This endpoint add a Book to database</strong>")
    public void add(final @RequestBody @Valid Book book) {
        bookService.save(book);
    }
}
