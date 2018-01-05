package com.zhaoxl.thread.third.join;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月03日上午11:51]
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println("last one ");
    }
}
