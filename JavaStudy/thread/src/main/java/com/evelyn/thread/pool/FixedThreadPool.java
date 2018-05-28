package com.evelyn.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明：固定大小的线程池
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月28日上午18:53]
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦。。。");
            });
        }

    }
}
