package com.java8.demo01_default_of_interface;

/**
 * 允许在接口中有默认方法实现 使用default关键字
 * Created by jiming.jing on 2020/3/19.
 */
public interface Formula {

    double calculate(int a);

    /**
     * 接口中的默认实现方法
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    /**
     * 接口中含有静态方法
     */
    static double plus(int a, int b) {
        return a + b;
    }
}
