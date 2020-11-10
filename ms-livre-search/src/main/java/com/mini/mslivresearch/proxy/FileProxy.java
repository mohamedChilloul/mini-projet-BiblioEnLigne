package com.mini.mslivresearch.proxy;

import com.mini.mslivresearch.model.LivreFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ms-livre-file")
public interface FileProxy {

    @GetMapping("/file/files/{id}")
    LivreFile getLivreFile(@PathVariable("id") Long id);
}
