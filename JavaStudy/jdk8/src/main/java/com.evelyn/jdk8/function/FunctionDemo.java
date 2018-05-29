package com.evelyn.jdk8.function;

import java.util.function.Function;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月14日上午15:43]
 */
public class FunctionDemo {

    static void modifyTheValue(int valueToBeOperated, Function<Integer,Integer> function) {
        int newValue = function.apply(valueToBeOperated);

        System.out.println(newValue);
    }

    public static void main(String[] args) {
        int incr = 20;
        int myNumber = 10;

        modifyTheValue(myNumber,val->val + incr);

        myNumber = 15;
        modifyTheValue(myNumber,val->val * 10 );

        modifyTheValue(myNumber,val->val - 100);

        modifyTheValue(myNumber,val->"somestring".length() + val - 100);
    }
}
