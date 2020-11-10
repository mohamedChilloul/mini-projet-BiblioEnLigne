package com.mini.cqrsquaryapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Catalogue {
    @Id
    private String idCatalogue;
    private String nomCatalogue;
    @ElementCollection
    private List<Livre> livres;
}
