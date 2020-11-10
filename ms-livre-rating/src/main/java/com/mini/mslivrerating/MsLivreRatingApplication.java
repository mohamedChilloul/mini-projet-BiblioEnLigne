package com.mini.mslivrerating;

import com.mini.mslivrerating.dao.LivreRatingRepository;
import com.mini.mslivrerating.dao.PersonRepository;
import com.mini.mslivrerating.dao.RatingRepository;
import com.mini.mslivrerating.entities.*;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class MsLivreRatingApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	LivreRatingRepository livreRatingRepository;
	@Autowired
	RatingRepository ratingRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsLivreRatingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//ajouter 2 personnes :
		Person person  = personRepository.save(
				new Person(null, "chilloul", "mohamed", Genre.malle, 21,null)
		);
		Person person2  = personRepository.save(
				new Person(null, "hamroun", "youcef", Genre.malle, 21,null)
				);
		Person person3  = personRepository.save(
				new Person(null, "patrik", "patrik", Genre.malle, 22,null)
				);

		//ajouter 2 livres
		LivreRating livreRating1 = livreRatingRepository.save(
				new LivreRating(1L,1,10,null)
		);

		LivreRating livreRating2 = livreRatingRepository.save(
				new LivreRating(2L,1,10,null)
		);

		//Ajouter les rating

		ratingRepository.save(
				new Rating( new KeyRating(person.getIdPerson(), livreRating1.getIdLivreRating()),2,"Nice book", Date.valueOf("1999-01-01"))
		);

		ratingRepository.save(
				new Rating( new KeyRating(person2.getIdPerson(), livreRating1.getIdLivreRating()),3,"jsp book", Date.valueOf("1999-01-01"))
		);
		ratingRepository.save(
				new Rating( new KeyRating(person.getIdPerson(), livreRating2.getIdLivreRating()),3,"jsp book", Date.valueOf("1999-01-01"))
		);






	}
}
