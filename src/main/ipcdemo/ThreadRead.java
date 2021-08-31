package main.ipcdemo;

import java.io.PipedInputStream;
import java.io.PipedReader;

public class ThreadRead extends Thread{

    private DataManager manager;
    private PipedInputStream inputStream;
    private PipedReader reader;

    public ThreadRead(DataManager manager, PipedInputStream inputStream) {
        this.manager = manager;
        this.inputStream = inputStream;
    }

    public ThreadRead(DataManager manager, PipedReader reader) {
        this.manager = manager;
        this.reader = reader;
    }

    @Override
    public void run() {
        //manager.readMethod(inputStream);
        manager.readMethod(reader);
    }
}
