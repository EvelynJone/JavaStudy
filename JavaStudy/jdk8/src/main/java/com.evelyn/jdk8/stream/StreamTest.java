package com.evelyn.jdk8.stream;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月30日上午9:37]
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = makeStringList(1000);

        long start = System.currentTimeMillis();
        list.stream().filter(t-> StringUtils.isNotEmpty(t))
                .map(t->getIdiom(t)).collect(Collectors.toList());
        System.out.println("stream : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        list.parallelStream().filter(t-> StringUtils.isNotEmpty(t))
                .map(t->getIdiom(t)).collect(Collectors.toList());
        System.out.println("parallelStream : " + (System.currentTimeMillis() - start));

    }

    private static List<String> getIdiom(String s) {
        String[] array = s.split("\\s+");
        List<String> list = Arrays.asList(array);
        return list.stream().filter(t->t.length() == 4).collect(Collectors.toList());
    }

    private static List<String> makeStringList(int size) {
        List<String> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list.add("S"+ i);
        }
        return list;
    }
}
