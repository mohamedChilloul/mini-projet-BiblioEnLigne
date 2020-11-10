package com.mini.mslivrecatalogue.dao;

import com.mini.mslivrecatalogue.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;
public interface LivreRepository extends JpaRepository<Livre, Long> {

}
