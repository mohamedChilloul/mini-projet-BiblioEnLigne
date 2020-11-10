package com.mini.cqrscoreapi.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data @AllArgsConstructor @NoArgsConstructor
public class CatalogueCreationCommand {
    @TargetAggregateIdentifier
    private String idCatalogue;
    private String nomCatalogue;
}
