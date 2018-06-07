package com.evelyn.jdk8.lambda;

/**
 * 功能说明：lambda方法引用
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年06月07日上午12:58]
 */
public class Greeter {
    public void greet() {
        System.out.println("Hello World");
    }
}

class ConcurrentGreeter extends Greeter {
    public void greet() {
        Thread t = new Thread(super::greet);
        t.start();
    }

    public static void main(String[] args) {
        ConcurrentGreeter greeter = new ConcurrentGreeter();
        greeter.greet();
    }
}
