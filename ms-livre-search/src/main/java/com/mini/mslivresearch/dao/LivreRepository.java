package com.mini.mslivresearch.dao;

import com.mini.mslivresearch.entities.Livre;
import com.mini.mslivresearch.entities.LivreStyle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findAllByTitle(String title);
    List<Livre> findAllByAuthor(String author);
    List<Livre> findAllByLivreStyle(LivreStyle style);
    //List<Livre> findAllByTitleContainingOrAuthorContainingOrDescriptionContaining(String keyWord);
}
