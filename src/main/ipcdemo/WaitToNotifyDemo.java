package main.ipcdemo;

public class WaitToNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Cooker a = new Cooker(obj);
        Waiter b = new Waiter(obj);
        b.start();
        Thread.sleep(300);
        a.start();
    }
}

