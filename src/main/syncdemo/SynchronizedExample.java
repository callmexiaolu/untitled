package main.syncdemo;

public class SynchronizedExample {

    private Object lockObj = new Object();

    public void testLockObj() {
        synchronized (lockObj) {

        }
    }

    public void testLockClass() {
        synchronized (SynchronizedExample.class) {

        }
    }

    public void testLockThis() {
        synchronized (this) {

        }
    }

    public synchronized static void synStaticTest() {

    }

    public synchronized void synTest() {

    }

}


