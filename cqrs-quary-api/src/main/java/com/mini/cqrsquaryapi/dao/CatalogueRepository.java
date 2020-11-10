package com.mini.cqrsquaryapi.dao;

import com.mini.cqrsquaryapi.entities.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue,String> {

}
