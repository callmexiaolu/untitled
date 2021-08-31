package main.ipcdemo;

import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class ThreadWrite extends Thread{

    private DataManager manager;
    private PipedOutputStream outputStream;
    private PipedWriter writer;

    public ThreadWrite(DataManager manager, PipedOutputStream out) {
        this.manager = manager;
        this.outputStream = out;
    }

    public ThreadWrite(DataManager manager, PipedWriter writer) {
        this.manager = manager;
        this.writer = writer;
    }

    @Override
    public void run() {
        //manager.writeMethod(outputStream);
        manager.writeMethod(writer);
    }
}
