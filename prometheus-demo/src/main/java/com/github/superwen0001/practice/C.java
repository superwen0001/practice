package com.github.superwen0001.practice;

import java.lang.management.ManagementFactory;

/**
 * Created by wenshiliang on 2017/4/12.
 */
public class C {
    public static void main(String[] args) {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
    }
}
