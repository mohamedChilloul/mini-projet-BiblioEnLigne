package com.mini.mslivresearch.entities;


import com.mini.mslivresearch.model.LivreFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Data @ToString
public class Livre {

    @Id
    private Long id_livre;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column
    private LivreStyle livreStyle;

    @Column(nullable = false)
    private String author;

    @Transient
    LivreFile livreFile;

    @Transient
    Double rateAvg;

}
