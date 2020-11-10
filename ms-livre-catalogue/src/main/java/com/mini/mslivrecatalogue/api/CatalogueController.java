package com.mini.mslivrecatalogue.api;

import com.mini.mslivrecatalogue.dao.LivreRepository;
import com.mini.mslivrecatalogue.entities.Livre;
import com.mini.mslivrecatalogue.model.LivreFile;
import com.mini.mslivrecatalogue.model.Rating;
import com.mini.mslivrecatalogue.proxy.FileProxy;
import com.mini.mslivrecatalogue.proxy.RatingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("catalogue")
public class CatalogueController {
    @Autowired
    LivreRepository livreRepository;

    @Autowired
    RatingProxy ratingProxy;

    @Autowired
    FileProxy fileProxy;


    //Invocation de ms-livre-file:

    @GetMapping("/livrePath/{id}")
    Livre getLivrePath(@PathVariable("id") Long id) {
        Livre livre = livreRepository.findById(id).get();
        LivreFile livreFile = fileProxy.getLivreFile(id);

        System.out.println(livreFile);

        livre.setLivreFile(fileProxy.getLivreFile(livre.getId_livre()));

        System.out.println(livre.getLivreFile());

        return livre;
    }

    @GetMapping("/allPath")
    List<LivreFile> getAllFiles() {
        return fileProxy.getAllFiles();
    }

    //pour un livre donnée je renvoi tous ces ratings en invoquant rating-ms:
    @GetMapping("/livre/{id}/ratings")
    Livre getLivreRatings(@PathVariable("id") Long id) {
        Livre livre = livreRepository.findById(id).get();
        livre.setRatings(ratingProxy.getLivreRatings(id));
        //livre.setRatings(null);
        return livre;
    }

    @GetMapping("/{id}/ratings")
    List<Rating> getRatings(@PathVariable("id") Long id) {
        return ratingProxy.getLivreRatings(id);
    }

    //retourne un livre avec son rate avg
    @GetMapping("/livre/{id}/avgRate")
    Livre getLivreAvgRate(@PathVariable("id") Long id) {
        Livre livre = livreRepository.findById(id).get();
        livre.setAvgRate(ratingProxy.getLivreAvgRate(id));
        return livre;
    }
    //retourn tous les livres, chaqu'un avec son DownLoadPath et le moyen de rating:

    @GetMapping("/all")
    List<Livre> getAll() {
        List<Livre> livres = livreRepository.findAll();
        for (int i = 0; i<livres.size();i++){
            livres.get(i).setLivreFile(fileProxy.getLivreFile(livres.get(i).getId_livre()));
            livres.get(i).setAvgRate(ratingProxy.getLivreAvgRate(livres.get(i).getId_livre()));
        }
        return livres;
    }





}
