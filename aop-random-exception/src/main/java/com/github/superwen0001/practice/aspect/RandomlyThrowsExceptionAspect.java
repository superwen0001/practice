package com.github.superwen0001.practice.aspect;

import com.github.superwen0001.practice.exception.RandomlyThrowsException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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
        int num = ThreadLocalRandom.current().nextInt(100);
        if (num % 10 == 0) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            RandomlyThrowsException randomlyThrowsException = method.getAnnotation(RandomlyThrowsException.class);
            String message = randomlyThrowsException.message();
            Class[] classes = randomlyThrowsException.throwable();
            Class clazz = classes[ThreadLocalRandom.current().nextInt(classes.length)];
            //注意,自定义的异常一定要有带一个String参数的构造函数
            Constructor c = clazz.getConstructor(String.class);
            throw (Throwable) c.newInstance(message);
        }
        return joinPoint.proceed();
    }

}
