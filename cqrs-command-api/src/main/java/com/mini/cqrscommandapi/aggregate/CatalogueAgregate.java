package com.mini.cqrscommandapi.aggregate;

import com.mini.cqrscoreapi.commands.CatalogueCreationCommand;
import com.mini.cqrscoreapi.commands.LivreCreationCommand;
import com.mini.cqrscoreapi.commands.RemoveLivreCommand;
import com.mini.cqrscoreapi.events.CatalogueCreatedEvent;
import com.mini.cqrscoreapi.events.LivreAddedEvent;
import com.mini.cqrscoreapi.events.LivreRemovedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Aggregate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogueAgregate {
    @AggregateIdentifier
    private String idCatalogue;
    private String nomCatalogue;

    private List<String> isbnLivres;


    @CommandHandler
    public CatalogueAgregate(CatalogueCreationCommand cmd) {

        Assert.notNull(cmd.getIdCatalogue(), "idCatalogue doit etre not null");
        Assert.notNull(cmd.getNomCatalogue(), "nom catalogue doit etre not null");

        AggregateLifecycle.apply(new CatalogueCreatedEvent(cmd.getIdCatalogue(), cmd.getNomCatalogue()));
    }

    @EventSourcingHandler
    public void on(CatalogueCreatedEvent event) {
        this.idCatalogue = event.getIdCatalogue();
        this.nomCatalogue = event.getNomCatalogue();
        this.isbnLivres = new ArrayList<>();
    }


    @CommandHandler
    public void handler(LivreCreationCommand cmd) throws Exception {
        Assert.notNull(cmd.getIdCatalogue(), "ID should not be null");
        Assert.notNull(cmd.getIsbn(), "Book ISBN should not be null");
        if (this.isbnLivres.contains(cmd.getIsbn()))
            throw new Exception("Book ISBN must be unique");

        AggregateLifecycle.apply(new LivreAddedEvent(
                cmd.getIdCatalogue(),
                cmd.getIsbn(),
                cmd.getTitle()));
    }

    @EventSourcingHandler
    private void on(LivreAddedEvent event) {
        this.isbnLivres.add(event.getIsbn());
    }

    @CommandHandler
    public void handler(RemoveLivreCommand cmd) throws Exception {
        Assert.notNull(cmd.getIdCatalogue(), "ID should not be null");
        Assert.notNull(cmd.getIsbn(), "Book ISBN should not be null");

        if (!this.isbnLivres.contains(cmd.getIsbn()))
            throw new Exception("Book ISBN must be unique");

        AggregateLifecycle.apply(new LivreRemovedEvent(
                cmd.getIdCatalogue(),
                cmd.getIsbn()));
    }

    @EventSourcingHandler
    private void on(LivreRemovedEvent event) {
        this.isbnLivres.remove(event.getIsbn());
    }


}
