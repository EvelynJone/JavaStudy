package com.evelyn.jdk8.lambda;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年06月08日上午13:44]
 */
public class ArraysSortThread {

    public static void main(String[] args) {
        String[] strings = new String[]{"q","a","b","sd","1","xsdfe","0","ss"};

        printTrack();
        Arrays.sort(strings);
        printTrack();
    }

    static void printTrack() {

            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null) {
                System.out.println("no stack trace");
                return;
            }
            StringBuffer sbf = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTrace.length > 0) {
                    sbf.append(" <- ").append(System.getProperty("line.separator"));
                }

                sbf.append(MessageFormat.format("{0}.{1}() {2}"
                        ,stackTraceElement.getClassName(),stackTraceElement.getMethodName(),stackTraceElement.getLineNumber()));
            }
            System.out.println(sbf.toString());

    }
}
