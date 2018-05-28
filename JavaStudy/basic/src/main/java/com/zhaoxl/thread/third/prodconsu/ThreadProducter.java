package com.zhaoxl.thread.third.prodconsu;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午12:59]
 */
public class ThreadProducter extends Thread{

    private Product product;

    public ThreadProducter(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            product.setValue();
        }
    }
}
