package com.github.superwen0001.practice.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wenshiliang on 2017/5/2.
 */
public class MapperProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                // 诸如hashCode()、toString()、equals()等方法，将target指向当前对象this
                return method.invoke(this, args);
            } catch (Throwable t) {
            }
        }
        // 投鞭断流
        return new User((Integer) args[0], "zhangsan", 18);
    }

    public static void main(String[] args) {
        MapperProxy mapperProxy = new MapperProxy();
        UserMapper mapper = mapperProxy.newInstance(UserMapper.class);
        User user = mapper.findUser(1);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.toString());
        System.out.println(mapper.toString());
    }
}
