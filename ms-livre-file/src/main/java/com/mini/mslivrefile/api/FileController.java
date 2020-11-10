package com.mini.mslivrefile.api;


import com.mini.mslivrefile.dao.LivreFileRepository;
import com.mini.mslivrefile.entities.LivreFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    LivreFileRepository livreFileRepository;
    @GetMapping("/files/{id}")
     LivreFile getPath(@PathVariable("id")Long id){
        System.out.println(id);
        System.out.println(livreFileRepository.findById(id).get().toString());
        LivreFile livreFile = livreFileRepository.getLivreFileByIdLivreFile(id);
        return livreFile;
    }

    @GetMapping("/files")
    List<LivreFile> getAllFiles(){
        return livreFileRepository.findAll();
    }
}
