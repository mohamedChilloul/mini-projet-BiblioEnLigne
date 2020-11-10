package com.mini.mslivrefile.dao;

import com.mini.mslivrefile.entities.LivreFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreFileRepository extends JpaRepository<LivreFile, Long> {
    LivreFile getLivreFileByIdLivreFile(Long id);
}
