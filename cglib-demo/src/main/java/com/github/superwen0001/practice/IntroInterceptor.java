package com.github.superwen0001.practice;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wenshiliang on 2017/4/28.
 */
public class IntroInterceptor implements MethodInterceptor,IHello {

    private Object delegate;

    public IntroInterceptor() {
        this.delegate = this;
    }

    public IntroInterceptor(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public void sayHello() {
        System.out.println("Say hello from delegate.");
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Class<?> clz = method.getDeclaringClass();
        if (clz.isAssignableFrom(IHello.class)) {
            // 如果实现了IHello增强接口，则调用实现类delegate的方法
            return method.invoke(delegate, args);
        }
        return methodProxy.invokeSuper(obj, args);
    }

    public static void main(String[] args) {
        Enhancer en = new Enhancer();
        en.setSuperclass(CeremenyService.class);
        en.setInterfaces(new Class[]{IHello.class});
        en.setCallback(new IntroInterceptor());

        CeremenyService cs = (CeremenyService) en.create();
        cs.sayBye();

        IHello ih = (IHello) cs;
        ih.sayHello();
    }
}
