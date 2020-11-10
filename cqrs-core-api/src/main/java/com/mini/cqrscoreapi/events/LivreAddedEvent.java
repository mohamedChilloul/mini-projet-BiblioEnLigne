package com.mini.cqrscoreapi.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivreAddedEvent {
    private String idCatalogue;
    private String isbn;
    private String title;
}
