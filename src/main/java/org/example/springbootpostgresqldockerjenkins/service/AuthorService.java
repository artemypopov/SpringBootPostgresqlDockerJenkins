package org.example.springbootpostgresqldockerjenkins.service;

import org.example.springbootpostgresqldockerjenkins.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface AuthorService  {

    Author create(Author entity);
    Author update(Author entity);
    Author getOne(Long id) ;
    List<Author> getAll();
    long getTotal();
    void delete(Long id);
    Page<Author> findAllPaginate(Pageable pageable);
    Page<Author> findAllSpecification(Specification<Author> specs, Pageable pageable);

}
