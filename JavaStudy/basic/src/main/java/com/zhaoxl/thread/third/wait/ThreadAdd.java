package com.zhaoxl.thread.third.wait;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午12:02]
 */
public class ThreadAdd extends Thread {

    private Add add;

    public ThreadAdd(Add add) {
        this.add = add;
    }

    public void run() {
        this.add.add();
    }
}
