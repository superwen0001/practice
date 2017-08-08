package com.github.superwen0001.practice.config;

import com.github.superwen0001.practice.aspect.RandomlyThrowsExceptionAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wenshiliang on 2017/8/8.
 */
@Configuration
public class ComonConfig {

    @Bean
    public RandomlyThrowsExceptionAspect randomlyThrowsExceptionAspect() {
        final int order = Byte.MAX_VALUE;
        RandomlyThrowsExceptionAspect randomlyThrowsExceptionAspect = new RandomlyThrowsExceptionAspect(order);
        return randomlyThrowsExceptionAspect;
    }
}
