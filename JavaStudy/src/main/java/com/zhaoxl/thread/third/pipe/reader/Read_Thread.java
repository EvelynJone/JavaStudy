package com.zhaoxl.thread.third.pipe.reader;

import java.io.PipedReader;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月03日上午11:33]
 */
public class Read_Thread extends Thread {

    private ReadData readData;
    private PipedReader reader;

    public Read_Thread(ReadData readData, PipedReader reader) {
        this.readData = readData;
        this.reader = reader;
    }

    @Override
    public void run() {
        readData.readMethod(reader);
    }
}
