package com.github.superwen0001.practice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wenshiliang on 2017/8/8.
 */
@Aspect
public class RandomlyThrowsExceptionAspect implements Ordered {
    private final int order;

    public RandomlyThrowsExceptionAspect(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }


    @Around("@annotation(com.github.superwen0001.practice.exception.RandomlyThrowsException)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        int num =  ThreadLocalRandom.current().nextInt(100);
        if(num%10 ==0){
            throw new RuntimeException("随机异常");
        }
        return joinPoint.proceed();
    }

}
