package com.mini.mslivrerating.api;

import com.mini.mslivrerating.dao.RatingRepository;
import com.mini.mslivrerating.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rating")
public class ratingController {

    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/person/{id}/livres")
    List<Rating> getPrsonLivres(@PathVariable("id")Long id){
        return ratingRepository.findAllByIdRating_Person(id);
    }

    @GetMapping("/livre/{id}/persons")
    List<Rating> getLivrePersons(@PathVariable("id") Long id){
        return ratingRepository.findAllByIdRating_LivreRating(id);
    }

    @GetMapping("/livre/{id}/rate")
    Double calculAvg(@PathVariable("id")Long id){
        return ratingRepository.avg(id);
    }



}
