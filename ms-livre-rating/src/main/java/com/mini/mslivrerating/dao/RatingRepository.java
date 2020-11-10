package com.mini.mslivrerating.dao;

import com.mini.mslivrerating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface RatingRepository extends JpaRepository<Rating,Long> {

    public List<Rating> findAllByIdRating_Person(Long id);

    public List<Rating> findAllByIdRating_LivreRating(Long id);
    @Query("SELECT avg(e.nbStars) FROM Rating e where e.idRating.livreRating=:id")
    Double avg(@Param("id") Long id);

}
