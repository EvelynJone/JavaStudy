package com.zhaoxl.thread.third.prodconsu.stack;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午19:30]
 */
public class C_Thread extends Thread {
    private Consumer consumer;

    public C_Thread(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.pop();
        }
    }
}
