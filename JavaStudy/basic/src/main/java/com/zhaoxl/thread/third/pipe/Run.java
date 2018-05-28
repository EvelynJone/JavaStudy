package com.zhaoxl.thread.third.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 功能说明：piped字节流传输
 * piped字符流是PipedReader，PipedWriter
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月02日上午19:52]
 */
public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {

        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();

        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream();

        out.connect(input);

        ReadThread readThread = new ReadThread(readData,input);
        readThread.start();

        Thread.sleep(1000);

        WriteThread writeThread = new WriteThread(writeData,out);
        writeThread.start();

    }
}
