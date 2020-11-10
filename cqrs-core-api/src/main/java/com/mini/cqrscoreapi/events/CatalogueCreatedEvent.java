package com.mini.cqrscoreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CatalogueCreatedEvent {
    private String idCatalogue;
    private String nomCatalogue;
}
