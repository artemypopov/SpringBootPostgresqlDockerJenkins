package org.example.springbootpostgresqldockerjenkins.controller;

import jakarta.validation.Valid;
import org.example.springbootpostgresqldockerjenkins.entity.Book;
import org.example.springbootpostgresqldockerjenkins.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService entityService;

    public BookController(BookService entityService) {
        this.entityService = entityService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book) {
        log.debug("REST request to save Book : {}", book);
        return new ResponseEntity<>(entityService.create(book), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book) {
        log.debug("REST request to update Book : {}", book);
        Book result = entityService.update(book);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBook() {
        log.debug("REST request to get all books");
        List<Book> lst = entityService.getAll();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getOneBook(@PathVariable("id") Long id) {
        log.debug("REST request to get Book : {}", id);
        Book e = entityService.getOne(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        log.debug("REST request to delete Book : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
