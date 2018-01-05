package com.zhaoxl.thread.third.join.exception;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月03日上午11:57]
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        threadB.start();

        Thread.sleep(500);

        ThreadC threadC = new ThreadC(threadB);
        threadC.start();
    }
}
