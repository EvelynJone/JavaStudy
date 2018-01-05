package com.zhaoxl.thread.third.prodconsu;

import com.zhaoxl.thread.third.wait.ValueObject;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午12:06]
 */
public class Product {

    private String lock;

    public Product(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("producter " + Thread.currentThread().getName() + " waiting");
                    lock.wait();
                }

                System.out.println("producter " + Thread.currentThread().getName() + " runnable ");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();

                ValueObject.value = value;
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
