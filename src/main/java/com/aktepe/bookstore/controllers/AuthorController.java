package com.aktepe.bookstore.controllers;

import com.aktepe.bookstore.entities.Author;
import com.aktepe.bookstore.services.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Api(tags = {"Author Controller"})
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ApiOperation(value = "Get All Authors", notes = "<strong>This endpoint returns all Authors in database</strong>")
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @DeleteMapping(value = "/{authorId}")
    @ApiOperation(value = "Delete Author By Id", notes = "<strong>This endpoint deletes author and relevant books by author id</strong>")
    public void delete(@PathVariable int authorId) {
        authorService.delete(authorId);
    }
}
