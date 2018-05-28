package com.zhaoxl.thread.third.join.exception;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月03日上午11:56]
 */
public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            ThreadA a = new ThreadA();
            a.start();
            a.join();
            System.out.println("threadB print in the last .");
        } catch (InterruptedException e) {
            System.out.println("threadB print in the cxception .");
            e.printStackTrace();
        }

    }
}
