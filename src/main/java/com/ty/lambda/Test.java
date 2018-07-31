package com.ty.lambda;

/**
 * 测试类
 *
 * @author tianyi
 */
public class Test {

    public static void main(String[] args) {
        //实现多线程
        Worker worker = new Worker();
        new Thread(worker).start();
    }
}
