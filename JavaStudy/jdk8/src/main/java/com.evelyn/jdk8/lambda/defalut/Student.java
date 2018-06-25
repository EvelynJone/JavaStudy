package com.evelyn.jdk8.lambda.defalut;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年06月08日上午10:01]
 */
public class Student implements Person,Named {
    @Override
    public String getName() {
        return Person.super.getName();
    }
}
