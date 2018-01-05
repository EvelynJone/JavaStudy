package com.zhaoxl.thread.third.pipe;

import java.io.PipedInputStream;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午19:50]
 */
public class ReadThread extends Thread {

    private ReadData readData;
    private PipedInputStream input;

    public ReadThread(ReadData readData, PipedInputStream input) {
        this.readData = readData;
        this.input = input;
    }

    @Override
    public void run() {
        readData.readMethod(input);
    }
}
