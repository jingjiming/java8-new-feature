package com.java8.demo05_internal_function;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by jiming.jing on 2020/3/20.
 */
public class InternalMethodTest {

    class Person {
        private String name;
        private Integer age;

        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * 测试1：测试Predicates函数（布尔类型函数）
     */
    @Test
    public void test1() {
        String source = "foo";
        Predicate<String> lenPredicate = (s) -> s.length() > 2;
        // test为抽象方法;and,negate,or,isEqual
        //1.基础用法以及negate测试
        System.out.println("布尔判断?" + lenPredicate.test(source)); // true
        System.out.println("非操作判断?" + lenPredicate.negate().test(source)); // false
        Predicate<Person> nonNull = Objects::nonNull;
        System.out.println("指向Objects的Person类型非空判断?" + nonNull.test(new Person())); //true
        Predicate<String> isNull = Objects::isNull;
        System.out.println("指向Objects的Person类型为空判断?" + isNull.test(null)); //true
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println("指向String的String类型为空判断?" + isEmpty.test("")); //true
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println("指向String的String类型为空判断?" + isNotEmpty.test("")); //true
        //2.and，or，isEqual测试
        Predicate<String> andPredicate = lenPredicate.and(isNotEmpty);
        Predicate<String> orPredicate = lenPredicate.or(isEmpty).or(isNull);
        Person person = new Person();
        Predicate<Person> isEqualPredicate = Predicate.isEqual(person);
        boolean result1 = andPredicate.test("123456"); //true && true
        boolean result2 = orPredicate.test("123456"); //true || false|| false
        System.out.println("and 测试：" + result1);
        System.out.println("or 测试：" + result2);
        System.out.println("isEqual 测试：" + isEqualPredicate.test(person));//true
    }
}
