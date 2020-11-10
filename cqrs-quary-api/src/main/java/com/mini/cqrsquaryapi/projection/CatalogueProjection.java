package com.mini.cqrsquaryapi.projection;

import com.mini.cqrscoreapi.commands.LivreCreationCommand;
import com.mini.cqrscoreapi.events.CatalogueCreatedEvent;
import com.mini.cqrscoreapi.events.LivreAddedEvent;
import com.mini.cqrscoreapi.events.LivreRemovedEvent;
import com.mini.cqrsquaryapi.dao.CatalogueRepository;
import com.mini.cqrsquaryapi.entities.Catalogue;
import com.mini.cqrsquaryapi.entities.Livre;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatalogueProjection {

    @Autowired
    private CatalogueRepository catalogueRepository;

    @EventHandler
    public void addCatalogue(CatalogueCreatedEvent event) {
        Catalogue catalogue = new Catalogue(event.getIdCatalogue(), event.getNomCatalogue(), null);
        catalogueRepository.save(catalogue);
    }

    @EventHandler
    public void addLivre(LivreAddedEvent event)  {
        Catalogue catalogue = catalogueRepository.findById(event.getIdCatalogue()).get();
        catalogue.getLivres().add(new Livre(event.getIsbn(),event.getTitle()));

        catalogueRepository.save(catalogue);
    }

    @EventHandler
    public void removeLivre(LivreRemovedEvent event){
        Catalogue catalogue = catalogueRepository.findById(event.getIdCatalogue()).get();
        catalogue.getLivres().remove(new Livre(event.getIsbn(), null));

        catalogueRepository.save(catalogue);
    }
}
