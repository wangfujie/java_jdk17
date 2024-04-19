package com.wang.java_jdk17;

import com.wang.java_jdk17.enums.FruitEnum;

/**
 * 描述
 *
 * @author wangfj
 * @date 2024/4/19
 */
public class TestMain {

    public static void main(String[] args) {
        String text = """
            {
              "name": "小黑说Java",
              "age": 18,
              "address": "北京市西城区"
            }
            """;
        System.out.println(text);

        withYield(FruitEnum.APPLE);

        record TestRecord(String name,int age){
            TestRecord{
                System.out.println("执行record类构造器：name=" + name + ", age=" + age);
            }
        }

        TestRecord testRecord = new TestRecord("zhangsan", 18);
        System.out.println(testRecord);
    }

    private static void withYield(FruitEnum fruit) {
        String text = switch (fruit) {
            case APPLE, PEAR -> {
                System.out.println("给的水果是: " + fruit);
                yield "普通水果";
            }
            case MANGO, AVOCADO -> "进口水果";
            default -> "未知水果";
        };
        System.out.println(text);
    }
}
