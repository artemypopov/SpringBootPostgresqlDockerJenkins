package org.example.springbootpostgresqldockerjenkins.service;

import org.example.springbootpostgresqldockerjenkins.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BookService {
    Book create(Book entity);
    Book update(Book entity);
    Book getOne(Long id) ;
    List<Book> getAll();
    long getTotal();
    void delete(Long id);
    Page<Book> findAllPaginate(Pageable pageable);
    Page<Book> findAllSpecification(Specification<Book> specs, Pageable pageable);

}
