package com.ty.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试类
 *
 * @author tianyi
 */
public class Test {

    public static void main(String[] args) {
        //实现多线程
        Worker worker = new Worker();
        //java8之前
        new Thread(worker).start();
        //java8
        new Thread(() -> {
            System.out.println("lambda实现多线程");
        }).start();
        //只有一行简化{}
        new Thread(() -> System.out.println("lambda实现多线程")).start();
        //使用类方法简化
        new Thread(() -> System.out.println("lambda实现多线程")).start();

        //实现比较器
        String[] strings = new String[]{"tony", "a", "tom", "jack"};
        Arrays.sort(strings, new LengthComparator());

        //java8
        Arrays.sort(strings, (first, second) -> {
            return Integer.compare(first.length(), second.length());
        });
        //代码中只有return语句，可简化
        Arrays.sort(strings, (first, second) -> Integer.compare(first.length(), second.length()));
        //参数调用其类的相同方法，再简化
        Arrays.sort(strings, Comparator.comparingInt(String::length));

        //一个抽象方法的接口用lambda
        new Test().testOneMethod(() -> System.out.println("使用lambda表达式实现接口"));

        //两个抽象方法的接口使用lambda
//        new Test().testTwoMethod(() -> System.out.println("使用lambda表达式实现接口"));
//        new Test().testTwoMethod((name) -> System.out.println(name));

        //方法引用::
        List<String> stringList = Arrays.asList(strings);
//        List<Integer> stringLength = stringList.stream().map(string -> string.length()).collect(Collectors.toList());
        List<Integer> stringLength = stringList.stream().map(String::length).collect(Collectors.toList());
    }

    void testOneMethod(IOneMethods iOneMethods){
        iOneMethods.method();
        System.out.println("为了使用lambda表达式");
    }

    void testTwoMethod(ITwoMethods iTwoMethods){
        System.out.println("为了使用lambda表达式");
    }

}
