package com.mini.mslivresearch.api;

import com.mini.mslivresearch.dao.LivreRepository;
import com.mini.mslivresearch.entities.Livre;
import com.mini.mslivresearch.entities.LivreStyle;
import com.mini.mslivresearch.proxy.FileProxy;
import com.mini.mslivresearch.proxy.RateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchApi {

    // Search API

    @Autowired
    FileProxy fileProxy;

    @Autowired
    LivreRepository livreRepository;
    @Autowired
    RateProxy rateProxy;

    @GetMapping("/titles/{title}")
    List<Livre> searchByTitle(@PathVariable("title") String title) {
        List<Livre> livres=livreRepository.findAllByTitle(title);
        for (int i=0; i<livres.size();i++)
        {
            livres.get(i).setLivreFile(fileProxy.getLivreFile(livres.get(i).getId_livre()));
            livres.get(i).setRateAvg(rateProxy.getLivreAvgRate(livres.get(i).getId_livre()));
        }
        return livres;
    }

    @GetMapping("/authors/{author}")
    List<Livre> searchByAuthor(@PathVariable("author") String author) {
        List<Livre> livres=livreRepository.findAllByAuthor(author);
        for (int i=0; i<livres.size();i++)
        {
            livres.get(i).setLivreFile(fileProxy.getLivreFile(livres.get(i).getId_livre()));
            livres.get(i).setRateAvg(rateProxy.getLivreAvgRate(livres.get(i).getId_livre()));
        }
        return livres;    }

    @GetMapping("/class/{style}")
    List<Livre> searchByStyle(@PathVariable("style") LivreStyle style) {
        List<Livre> livres=livreRepository.findAllByLivreStyle(style);
        for (int i=0; i<livres.size();i++)
        {
            livres.get(i).setLivreFile(fileProxy.getLivreFile(livres.get(i).getId_livre()));
            livres.get(i).setRateAvg(rateProxy.getLivreAvgRate(livres.get(i).getId_livre()));
        }
        return livres;
    }


}
