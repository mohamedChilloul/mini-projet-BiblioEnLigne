package com.mini.mslivrerating.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Rating {

    @EmbeddedId
    private KeyRating idRating;
    @Column
    private int nbStars;
    @Column
    private String remark;
    @Column
    @Temporal(TemporalType.DATE)
    private Date ratingDate;
}
