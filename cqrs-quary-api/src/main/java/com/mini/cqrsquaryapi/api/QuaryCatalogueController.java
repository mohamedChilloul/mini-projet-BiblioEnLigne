package com.mini.cqrsquaryapi.api;

import com.mini.cqrsquaryapi.dao.CatalogueRepository;
import com.mini.cqrsquaryapi.entities.Catalogue;
import com.mini.cqrsquaryapi.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quary")
public class QuaryCatalogueController {
    @Autowired
    private CatalogueRepository catalogueRepository;

    @GetMapping("/catalogue/{id}")
    public Catalogue getLibraryById(@PathVariable String id) {
        return catalogueRepository.findById(id).get();
    }

    @GetMapping("/catalogue")
    public List<Catalogue> getLibraries() {
        return catalogueRepository.findAll();
    }

    @GetMapping("/library/{id}/book")
    public List<Livre> getBooksByLibrary(@PathVariable String id) {
        return catalogueRepository.findById(id).get().getLivres();
    }
}
