package com.mini.mslivrerating.dao;

import com.mini.mslivrerating.entities.LivreRating;
import com.mini.mslivrerating.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface PersonRepository extends JpaRepository<Person, Long> {
}
