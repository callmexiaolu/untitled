package main.ipcdemo;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread{

    private DataManager manager;
    private PipedOutputStream outputStream;

    public ThreadWrite(DataManager manager, PipedOutputStream out) {
        this.manager = manager;
        this.outputStream = out;
    }

    @Override
    public void run() {
        manager.writeMethod(outputStream);
    }
}
