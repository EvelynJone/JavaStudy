package com.zhaoxl.thread.third.prodconsu;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午13:01]
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Product p = new Product(lock);
        Consumer consumer = new Consumer(lock);

        ThreadProducter[] producter =
                new ThreadProducter[2];
        ThreadConsumer[] consumers =
                new ThreadConsumer[2];

        for (int i = 0; i < 2; i++) {
            producter[i] = new ThreadProducter(p);
            producter[i].setName("procuter" + ( i + 1));

            consumers[i] = new ThreadConsumer(consumer);
            consumers[i].setName("consumer" + (i + 1));

            producter[i].start();
            consumers[i].start();
         }

         Thread.sleep(5000);

        Thread[] treadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];

        Thread.currentThread().getThreadGroup().enumerate(treadArray);
        for (int i = 0; i < treadArray.length; i++) {
            System.out.println(treadArray[i].getName() + " " + treadArray[i].getState());
        }
    }
}
