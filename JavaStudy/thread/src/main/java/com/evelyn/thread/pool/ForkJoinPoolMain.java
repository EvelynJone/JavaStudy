package com.evelyn.thread.pool;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月28日上午19:45]
 */
public class ForkJoinPoolMain {
    /**
     * 定义一个可分解的任务类
     */
    public static class MyTask extends RecursiveAction {

        // 定义一个分解任务的阈值是-50，即一个任务最多承担50个工作量
        int THRESHOLD = 50;
        // 任务量
        int task_num = 0;

        public MyTask(int task_num) {
            this.task_num = task_num;
        }

        @Override
        protected void compute() {
            if (task_num <= THRESHOLD) {
                System.out.println(Thread.currentThread().getName() + "承担了" + task_num + " 份工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                // 随机分解成两个任务
                Random r = new Random();
                int x = r.nextInt(50);

                MyTask left = new MyTask(x);
                MyTask right = new MyTask(task_num - x);

                left.fork();
                right.fork();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

        MyTask task = new MyTask(178);

        pool.submit(task);
        pool.awaitTermination(20, TimeUnit.SECONDS); //等待20s，观察结果
        pool.shutdown();
    }
}
