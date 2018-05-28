package com.zhaoxl.thread.third.pipe.reader;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年01月03日上午11:35]
 */
public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();

        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();

        writer.connect(reader);

        Read_Thread read_thread = new Read_Thread(readData,reader);
        read_thread.start();

        Thread.sleep(1000);

        Writer_Thread writer_thread = new Writer_Thread(writeData,writer);
        writer_thread.start();


    }
}
