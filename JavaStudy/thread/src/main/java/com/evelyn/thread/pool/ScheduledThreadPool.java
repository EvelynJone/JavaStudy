package com.evelyn.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：周期性
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月28日上午19:07]
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);

        // 延迟10s执行任务
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            pool.schedule(()->{
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦。。。");
            },10, TimeUnit.SECONDS);
        }

      /*  pool.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName() + "\t开始发车啦。。。");
        },1,1,TimeUnit.SECONDS);*/


    }
}
