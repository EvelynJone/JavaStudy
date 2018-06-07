package com.evelyn.jdk8.lambda;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年06月06日上午13:02]
 */
public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        return Integer.compare(first.length(),second.length());
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"a","dd","cc","a","ddddd","mlkdjkfdi"};

        // 几种不同的方式

        // 传统方式
        Arrays.sort(strings,new LengthComparator());
        // 1.8lambda方式:只有一个表达式，可省略return语句
        Arrays.sort(strings,(String first,String second) -> Integer.compare(first.length(),second.length()));
        // 1.8lambda方式:多个语句，需要加return语句
        Arrays.sort(strings,(String first,String second) ->{
            if (first.length() < second.length()) return -1;
            else if (first.length() > second.length()) return 1;
            else return 0;
        });
        // 1.8 api封装的lambda方式
        Arrays.sort(strings,Comparator.comparingInt(t->t.length()));

        Comparator<String> comp =
                (c1, c2) -> Integer.compare(c1.length(),c2.length());

        Arrays.stream(strings).forEach(t-> System.out.println(t));

        EventHandler<ActionEvent> listener = event -> {
            System.out.println("thanks");
        };

        Arrays.sort(strings,String::compareToIgnoreCase);
    }
}
