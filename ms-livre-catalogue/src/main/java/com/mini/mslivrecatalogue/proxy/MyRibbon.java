package com.mini.mslivrecatalogue.proxy;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbon {
    @Bean
    public IRule rule()
    {
        return new WeightedResponseTimeRule();
    }
}
