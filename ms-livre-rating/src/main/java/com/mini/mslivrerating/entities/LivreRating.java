package com.mini.mslivrerating.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LivreRating {
    @Id
    private Long idLivreRating;

    @Column
    private int nbLikes;

    @Column
    private int nbViews;


    //a boock can be rated by many persons
    @OneToMany(mappedBy = "idRating.livreRating")
    List<Rating> ratings;

}
