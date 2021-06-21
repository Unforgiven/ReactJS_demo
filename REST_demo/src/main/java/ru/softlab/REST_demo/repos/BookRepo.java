package ru.softlab.REST_demo.repos;

import org.springframework.data.repository.CrudRepository;
import ru.softlab.REST_demo.domain.Book;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Long> {

    //Book findById();
    Book findByTitle(String title);
    List<Book> findByAuthor(String author);
}
