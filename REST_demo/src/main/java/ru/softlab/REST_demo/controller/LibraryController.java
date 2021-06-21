package ru.softlab.REST_demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.softlab.REST_demo.domain.Book;
import ru.softlab.REST_demo.exceptions.NotFoundException;
import ru.softlab.REST_demo.repos.BookRepo;
import ru.softlab.REST_demo.service.LibraryService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest/library")
@CrossOrigin(origins="http://localhost:3000")
public class LibraryController {

    private static final Logger log = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    LibraryService libraryService;

    @GetMapping
    public ResponseEntity<Iterable<Book>> findAll() {

        return libraryService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {

        return libraryService.findById(id);
    }

    @GetMapping("author/{author}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable String author) {

        return libraryService.findByAuthor(author);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return libraryService.create(book);
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book) {
        return libraryService.update(book);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(libraryService.delete(id), HttpStatus.OK);
    }
}