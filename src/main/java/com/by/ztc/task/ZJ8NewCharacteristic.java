package com.by.ztc.task;

import java.util.Arrays;

/**
 * java8 新特性
 * <p>
 * 状态：《实验开始》
 *
 * @author zwp
 */
public class ZJ8NewCharacteristic {

    public static void main(String[] args) {
        // 1、Lambda表达式
        Arrays.asList("a", "b", "c").forEach(
                e -> System.out.println(e)
        );

        Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));

        System.out.println("------");
        Arrays.asList("a", "b", "d").forEach(e -> {
            System.out.print(e);
            System.out.print(e);
        });

        String separator = ",";
        Arrays.asList("a", "b", "d").forEach(
                (String e) -> System.out.print(e + separator));


        String[] ss = {"a", "b", "e", "d"};
        System.out.println("---");
        for (String s : ss
                ) {
            System.out.print(s);
        }
        System.out.println("\n");
        Arrays.asList(ss).sort((e1, e2) -> e1.compareTo(e2));
        for (String s : ss
                ) {
            System.out.print(s);
        }

        Arrays.asList("a", "b", "d").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
    }


}
