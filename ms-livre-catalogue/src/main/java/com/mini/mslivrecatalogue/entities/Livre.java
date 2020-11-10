package com.mini.mslivrecatalogue.entities;

import com.google.inject.internal.asm.$Type;
import com.mini.mslivrecatalogue.model.LivreFile;
import com.mini.mslivrecatalogue.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Data @ToString
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livre;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column
    private LivreStyle livreStyle;

    @Column(nullable = false)
    private String author;

    @Column
    private String editor;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dateEdition;

    @Transient
    private LivreFile livreFile;
    @Transient
    private List<Rating> ratings;
    @Transient
    private Double avgRate;
}
