package com.zhaoxl.thread.third.join;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月03日上午11:49]
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            int secondValue = (int)Math.random() * 10000;
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
