package main.ipcdemo;

import java.io.PipedInputStream;

public class ThreadRead extends Thread{

    private DataManager manager;
    private PipedInputStream inputStream;

    public ThreadRead(DataManager manager, PipedInputStream inputStream) {
        this.manager = manager;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        manager.readMethod(inputStream);
    }
}
