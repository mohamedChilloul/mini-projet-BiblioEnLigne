package com.mini.mslivrefile;

import com.mini.mslivrefile.dao.LivreFileRepository;
import com.mini.mslivrefile.entities.LivreFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsLivreFileApplication implements CommandLineRunner {

	@Autowired
	LivreFileRepository livreFileRepository;
	public static void main(String[] args) {
		SpringApplication.run(MsLivreFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		livreFileRepository.save(new LivreFile(1L, "path////"));
		livreFileRepository.save(new LivreFile(2L, "path22////"));
	}
}
