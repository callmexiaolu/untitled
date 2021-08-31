package main.ipcdemo;

public class ThreadSubTract extends Thread{

    private Subtract t;

    public ThreadSubTract(Subtract t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.subTrack();
    }
}
