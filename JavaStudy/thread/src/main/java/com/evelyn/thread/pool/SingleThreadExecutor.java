package com.evelyn.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明：单线程的线程池
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月28日上午17:35]
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦。。。");
            });
        }
    }
}
