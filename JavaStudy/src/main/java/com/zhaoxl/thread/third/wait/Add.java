package com.zhaoxl.thread.third.wait;

/**
 * 功能说明：TODO
 *
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午11:09] 创建方法 by hw
 */
public class Add {

    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ValueObject.list.add("add any thing");
            lock.notifyAll();
        }
    }
}
