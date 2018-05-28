package com.zhaoxl.thread.third.prodconsu.stack;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午19:29]
 */
public class Consumer {
    private MyStack myStack;

    public Consumer(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pop() {
        System.out.println("pop=" + myStack.pop());
    }
}
