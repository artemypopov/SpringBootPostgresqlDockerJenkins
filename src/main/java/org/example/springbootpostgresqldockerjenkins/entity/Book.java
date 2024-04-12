package org.example.springbootpostgresqldockerjenkins.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book", schema = "public")
public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "descripton")
    private String description;

    @Column(name = "page")
    private Integer page;

    @Column(name = "price")
    private BigDecimal price;

}
