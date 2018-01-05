package com.zhaoxl.thread.third.prodconsu.stack;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午19:30]
 */
public class P_Thread extends Thread {

    private Producter producter;

    public P_Thread(Producter producter) {
        this.producter = producter;
    }

    @Override
    public void run() {
        while (true) {
            producter.push();
        }
    }
}
