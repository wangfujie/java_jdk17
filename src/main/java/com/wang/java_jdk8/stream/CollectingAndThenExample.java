package com.wang.java_jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述
 *
 * @author wangfj
 * @date 2024/6/11
 */
public class CollectingAndThenExample {

    /**
     * Collectors.collectingAndThen() 函数应该最像 map and reduce 了，它可接受两个参数，第一个参数用于 reduce 操作，而第二参数用于 map 操作。
     *
     * 也就是，先把流中的所有元素传递给第二个参数，然后把生成的集合传递给第一个参数来处理。
     *
     * 例如下面的代码，先把 [1,2,3,4]
     * 这个集合传递给 s->s*s lambda 表达式，计算得出结果为 [1,4,9,16] ，
     * 然后再把 [1,4,9,16] 传递给 v->v*2 表达式，计算得出 [2,8,18,32] ，
     * 然后传递给 Collectors.averagingLong()
     * 计算得到结果为 25.0
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double result = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v->v*2),
                s-> s*s));
        System.out.println(result);
    }
}
