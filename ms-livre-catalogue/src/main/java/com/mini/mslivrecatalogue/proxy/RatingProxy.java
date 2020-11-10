package com.mini.mslivrecatalogue.proxy;


import com.mini.mslivrecatalogue.model.Rating;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RibbonClient(name = "ms-livre-rating")
@FeignClient(name = "ms-livre-rating", configuration = MyRibbon.class)
public interface RatingProxy {

    @GetMapping("/rating/livre/{id}/persons")
    List<Rating> getLivreRatings(@PathVariable("id")Long id);

    @GetMapping("/rating/livre/{id}/rate")
    Double getLivreAvgRate(@PathVariable("id") Long id);
}
