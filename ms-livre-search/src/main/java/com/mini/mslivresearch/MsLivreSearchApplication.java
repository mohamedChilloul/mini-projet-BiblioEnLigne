package com.mini.mslivresearch;

import com.mini.mslivresearch.dao.LivreRepository;
import com.mini.mslivresearch.entities.Livre;
import com.mini.mslivresearch.entities.LivreStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class MsLivreSearchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MsLivreSearchApplication.class, args);
	}

	@Autowired
	LivreRepository livreRepository;
	@Override
	public void run(String... args) throws Exception {
		livreRepository.save(new Livre(1L, "title", "description", LivreStyle.FANTASY, "author1",null,null));
		livreRepository.save(new Livre(2L, "title2", "description2", LivreStyle.FANTASY, "author2",null,null));

	}
}
