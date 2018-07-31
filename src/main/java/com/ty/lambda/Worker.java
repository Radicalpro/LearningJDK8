package com.ty.lambda;

/**
 * 接口实现多线程
 *
 * @author tianyi
 */
public class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("实现runnable接口，实现多线程");
    }
}
