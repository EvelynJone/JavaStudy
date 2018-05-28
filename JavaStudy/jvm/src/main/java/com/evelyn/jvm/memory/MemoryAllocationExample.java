package com.evelyn.jvm.memory;

/**
 * 功能说明：运行时，jvm把类的代码全部都放入方法区
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月25日上午11:01]
 */

public class MemoryAllocationExample {

    /**
     * main方法本身放入方法区
     * @param args
     */
    public static void main(String[] args) {
        // test1是引用，所以放入栈区，Bean是自定义对象，应该放入堆里
        Bean test1 = new Bean("test1");
        Bean test2 = new Bean("test2");

        test1.printName();
        test2.printName();
    }
}

/**
 * 功能说明：范例
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月25日上午11:03]
 */
class Bean {
    // 范例名称
    // new Bean实例后，name引用放入栈区里，nane对应的String对象放入堆里
    private String name;

    public Bean(String name) {
        this.name = name;
    }

    /**
     * 输出
     * 在没有对象的时候，printName方法跟随Bean类被放入方法区里
     */
    public void printName() {
        System.out.println(name);
    }
}



