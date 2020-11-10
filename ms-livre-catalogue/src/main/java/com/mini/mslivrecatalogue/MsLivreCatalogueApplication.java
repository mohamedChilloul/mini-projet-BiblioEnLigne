package com.mini.mslivrecatalogue;

import com.mini.mslivrecatalogue.dao.LivreRepository;
import com.mini.mslivrecatalogue.entities.Livre;
import com.mini.mslivrecatalogue.entities.LivreStyle;
import com.mini.mslivrecatalogue.model.LivreFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class MsLivreCatalogueApplication implements CommandLineRunner {

    @Autowired
    LivreRepository livreRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsLivreCatalogueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        livreRepository.save(new Livre(null, "isbn", "title", "description", LivreStyle.FANTASY, "author1", "editor1", Date.valueOf("1999-1-25"), null, null, null));
        livreRepository.save(new Livre(null, "isbn2", "title2", "description2", LivreStyle.MYSTERY, "author2", "editor2", Date.valueOf("1999-1-22"), null, null, null));

        livreRepository.findAll().forEach(System.out::println);

    }
}
