package org.example.springbootpostgresqldockerjenkins.controller;

import jakarta.validation.Valid;
import org.example.springbootpostgresqldockerjenkins.entity.Author;
import org.example.springbootpostgresqldockerjenkins.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final Logger log = LoggerFactory.getLogger(AuthorController.class);

    private final AuthorService entityService;

    public AuthorController (AuthorService entityService) {
        this.entityService = entityService;
    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody @Valid Author author) {
        log.debug("REST request to save Author : {}", author);
        return new ResponseEntity<>(entityService.create(author), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Author> updateAuthor(@Valid @RequestBody Author author) {
        log.debug("REST request to update Author : {}", author);
        Author result = entityService.update(author);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        log.debug("REST request to get all authors");
        List<Author> lst = entityService.getAll();

        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getOneAuthor(@PathVariable("id") Long id) {
        log.debug("REST request to get Author : {}", id);
        Author e = entityService.getOne(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Long id) {
        log.debug("REST request to delete Author : {}", id);
        entityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
