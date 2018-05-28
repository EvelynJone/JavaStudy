package com.zhaoxl.thread.third.prodconsu.stack;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午19:28]
 */
public class Producter {
    private MyStack myStack;

    public Producter(MyStack myStack) {
        this.myStack = myStack;
    }

    public void push() {
        myStack.push();
    }
}
