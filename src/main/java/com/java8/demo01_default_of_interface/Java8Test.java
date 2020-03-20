package com.java8.demo01_default_of_interface;

import org.junit.Test;

/**
 * Created by jiming.jing on 2020/3/19.
 */
public class Java8Test {

    /**
     * 测试1：调用接口的默认实现方法
     */
    @Test
    public void test1() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };
        double r1 = formula.calculate(100); // 10.0
        double r2 = formula.sqrt(16); // 4.0
        System.out.println("r1=" + r1);
        System.out.println("r2=" + r2);
    }

    /**
     * 测试2：复写接口的default方法
     */
    @Test
    public void test2() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return a * a;
            }

            //复写父类默认接口实现方法
            @Override
            public double sqrt(int a) {
                return 1 + 2;
            }
        };
        double r1 = formula.sqrt(9);
        System.out.println("r1 = " + r1);
    }
}
