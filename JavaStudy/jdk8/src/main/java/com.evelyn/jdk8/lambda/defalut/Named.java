package com.evelyn.jdk8.lambda.defalut;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年06月08日上午9:58]
 */
public interface Named {

    default String getName() {
        return getClass().getName()+"_"+hashCode();
    }
}
