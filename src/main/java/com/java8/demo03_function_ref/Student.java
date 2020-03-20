package com.java8.demo03_function_ref;

/**
 * Created by jiming.jing on 2020/3/19.
 */
public class Student {

    private String name;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void staticMethod(Student student) {
        System.out.println("静态方法:[" + student.getName() + "]");
    }
}
