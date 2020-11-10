package com.mini.mslivrecatalogue.proxy;

import com.mini.mslivrecatalogue.entities.Livre;
import com.mini.mslivrecatalogue.model.LivreFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-livre-file",url = "http://localhost:8084")
public interface FileProxy {

    @GetMapping("/file/files/{id}")
    LivreFile getLivreFile(@PathVariable("id") Long id);

    @GetMapping("/file/files")
    List<LivreFile> getAllFiles();
}
