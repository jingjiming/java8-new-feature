package com.java8.demo03_function_ref;

/**
 * Created by jiming.jing on 2020/3/19.
 */
public class Java8 {

    private String version;

    /*构造方法*/
    public Java8(String version) {
        this.version = version;
    }

    /*成员方法*/
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    /*静态方法*/
    public static String sayVersion(String version) {
        return "Java8{version='" + version + '\'' + '}';
    }
}
