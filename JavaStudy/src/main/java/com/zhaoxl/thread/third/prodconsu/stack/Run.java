package com.zhaoxl.thread.third.prodconsu.stack;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午19:31]
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        Producter producter = new Producter(myStack);
        Producter producter1 = new Producter(myStack);
        Producter producter2 = new Producter(myStack);
        Producter producter3 = new Producter(myStack);
        Producter producter4 = new Producter(myStack);

        Consumer consumer = new Consumer(myStack);
        Consumer consumer1 = new Consumer(myStack);
        Consumer consumer2 = new Consumer(myStack);
        Consumer consumer3 = new Consumer(myStack);
        Consumer consumer4 = new Consumer(myStack);

        P_Thread p_thread = new P_Thread(producter);
        P_Thread p_thread1 = new P_Thread(producter1);
        P_Thread p_thread2 = new P_Thread(producter2);
        P_Thread p_thread3 = new P_Thread(producter3);
        P_Thread p_thread4 = new P_Thread(producter4);

        C_Thread c_thread = new C_Thread(consumer);
        C_Thread c_thread1 = new C_Thread(consumer1);
        C_Thread c_thread2 = new C_Thread(consumer2);
        C_Thread c_thread3 = new C_Thread(consumer3);
        C_Thread c_thread4 = new C_Thread(consumer4);

        p_thread.start();
        p_thread1.start();
        p_thread2.start();
        p_thread3.start();
        p_thread4.start();

        c_thread.start();
        c_thread1.start();
        c_thread2.start();
        c_thread3.start();
        c_thread4.start();
    }
}
