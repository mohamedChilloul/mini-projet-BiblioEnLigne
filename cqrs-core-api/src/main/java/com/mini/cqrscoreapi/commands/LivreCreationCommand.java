package com.mini.cqrscoreapi.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivreCreationCommand {
    @TargetAggregateIdentifier
    private String idCatalogue;
    private String isbn;
    private String title;
}
