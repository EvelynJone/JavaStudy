package com.zhaoxl.thread.third.pipe.reader;

import java.io.PipedWriter;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月03日上午11:34]
 */
public class Writer_Thread extends Thread {

    private WriteData writeData;
    private PipedWriter writer;

    public Writer_Thread(WriteData writeData, PipedWriter writer) {
        this.writeData = writeData;
        this.writer = writer;
    }

    @Override
    public void run() {
        writeData.writeMethod(writer);
    }
}
