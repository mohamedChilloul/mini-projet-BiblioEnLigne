package com.mini.mslivrefile.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class LivreFile {

    @Id
    private Long idLivreFile;
    @Column(unique = true, nullable = false)
    private String DownloadPath;
}
