package com.zhaoxl.thread.third.prodconsu;

import com.zhaoxl.thread.third.wait.ValueObject;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午12:56]
 */
public class Consumer {
    private String lock;

    public Consumer(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("")) {
                    System.out.println("consumer " + Thread.currentThread().getName() +
                            " waiting ");
                    lock.wait();
                }
                System.out.println("consumer " + Thread.currentThread().getName()
                        + " runnable ");
                synchronized (ValueObject.value) {
                    ValueObject.value = "";
                }

                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
