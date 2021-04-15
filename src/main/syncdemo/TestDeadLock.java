package main.syncdemo;

/**
 * 测试死锁
 */
public class TestDeadLock {

    public Object objectA = new Object();
    public Object objectB = new Object();

    public Thread thread1 = new Thread(() -> {
        synchronized (objectA) {
            System.out.println("进入了thread1--objectA");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectB) {
                System.out.println("进入了thread1--objectB");
            }
        }
    });

    public Thread thread2 = new Thread(() -> {
        synchronized (objectB) {
            System.out.println("进入了thread2--objectB");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectA) {
                System.out.println("进入了thread2--objectA");
            }
        }
    });


    public static void main(String[] args) {
        TestDeadLock lock = new TestDeadLock();
        lock.thread1.start();
        lock.thread2.start();
    }



}
