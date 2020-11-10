package com.mini.mslivresearch.proxy;

import org.hibernate.annotations.OptimisticLocking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ms-livre-rating")
public interface RateProxy {
    @GetMapping("/rating/livre/{id}/rate")
    Double getLivreAvgRate(@PathVariable("id") Long id);
}
