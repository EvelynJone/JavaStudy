package com.zhaoxl.thread.third.dbtool;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月03日上午11:46]
 */
public class Run {
    public static void main(String[] args) {
        DBTools tools = new DBTools();

        for (int i = 0; i < 20; i++) {
            BackupB out = new BackupB(tools);
            out.start();
            BackupA input = new BackupA(tools);
            input.start();
        }
    }
}
