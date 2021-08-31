package main.ipcdemo;

import java.io.*;

public class PipedRun {
    public static void main1(String[] args) throws InterruptedException, IOException {
        DataManager manager = new DataManager();

        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        //connect使两个stream之间产生通信连接，才可以使数据进行输入输出
        outputStream.connect(inputStream);

        ThreadRead read = new ThreadRead(manager, inputStream);
        ThreadWrite write = new ThreadWrite(manager, outputStream);

        read.start();
        Thread.sleep(2000);
        write.start();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        DataManager manager = new DataManager();

        PipedWriter outputStream = new PipedWriter();
        PipedReader inputStream = new PipedReader();
        //connect使两个stream之间产生通信连接，才可以使数据进行输入输出
        outputStream.connect(inputStream);

        ThreadRead read = new ThreadRead(manager, inputStream);
        ThreadWrite write = new ThreadWrite(manager, outputStream);

        read.start();
        Thread.sleep(2000);
        write.start();
    }
}
