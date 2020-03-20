package com.java8.demo07_parllel_stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 并行流操作
 * Created by jiming.jing on 2020/3/21.
 */
public class ParallelStreamTest {

    private List<String> values = new ArrayList<>();

    /**
     * 测试1：原始排序
     */
    @Before
    public void initData() {
        final int N = 900000;
        for (int i = 0; i < N; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    /**
     * 测试1：顺序流操作
     */
    @Test
    public void test1() {
        //1000000 3s 570ms
        //9000000 23s 464ms
        values.stream().sorted();
    }

    /**
     * 测试2：并行流操作
     */
    @Test
    public void test2() {
        //1000000 2s 956ms
        //9000000 21s 227ms
        values.parallelStream().sorted();
    }

}
