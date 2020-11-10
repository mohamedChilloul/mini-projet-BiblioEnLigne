package com.mini.msgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {
    @GetMapping("/defaultCatalogue")
    Livre catalogueFallBack(){
        return new Livre();
    }

    @GetMapping("/defaultRating")
    String RatingFallBack(){
        return  "le ms-rating ne marche pas !";
    }

    @GetMapping("/defaultSearch")
    String SearchFallBack(){
        return  "le ms-rating ne marche pas !";
    }
}
