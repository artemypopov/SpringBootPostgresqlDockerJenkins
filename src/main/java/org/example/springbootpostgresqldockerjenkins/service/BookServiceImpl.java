package org.example.springbootpostgresqldockerjenkins.service;

import org.example.springbootpostgresqldockerjenkins.entity.Book;
import org.example.springbootpostgresqldockerjenkins.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {


    private final BookRepository repository;

    public BookServiceImpl(BookRepository repo) {
        this.repository = repo;
    }


    @Override
    public Book create(Book d) {
        try {
            return repository.save(d);

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Book update(Book d) {
        try {
            return repository.saveAndFlush(d);

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Book getOne(Long id) {
        try {
            return repository.findById(id).orElse(null);

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Book> getAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    @Override
    public long getTotal() {
        try {
            return repository.count();
        } catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Book> findAllPaginate(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Override
    public Page<Book> findAllSpecification(Specification<Book> specs, Pageable pageable) {
        return repository.findAll(specs, pageable);
    }
}
