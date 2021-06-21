package ru.softlab.REST_demo.service;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.softlab.REST_demo.domain.Book;
import ru.softlab.REST_demo.repos.BookRepo;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    BookRepo bookRepo;

    public LibraryService() {
    }


    public ResponseEntity<Iterable<Book>> findAll() {

        return new ResponseEntity<>(bookRepo.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<Book> findById(Long id) {

        return new ResponseEntity<>(bookRepo.findById(id).get(), HttpStatus.OK);
    }


    public ResponseEntity<List<Book>> findByAuthor(String author) {

        return new ResponseEntity<>(bookRepo.findByAuthor(author), HttpStatus.OK);
    }


    public ResponseEntity<Book> create(Book book) {
        return new ResponseEntity<>(bookRepo.save(book), HttpStatus.CREATED);
    }


    public ResponseEntity<Book> update(Book book) {
        return new ResponseEntity<>(bookRepo.save(book), HttpStatus.OK);
    }


    public String delete(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            bookRepo.delete(bookRepo.findById(id).get());
            jsonObject.put("message", "Book was deleted");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
