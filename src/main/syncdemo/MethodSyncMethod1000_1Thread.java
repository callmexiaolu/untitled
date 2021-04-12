package main.syncdemo;

//线程1-调用 synchronized方法
public class MethodSyncMethod1000_1Thread extends Thread {

    private Resource syncMethodTest;

    public MethodSyncMethod1000_1Thread(Resource syncMethodTest) {
        this.syncMethodTest = syncMethodTest;
    }

    @Override
    public void run() {
        syncMethodTest.testSyncMethod1000_1();
    }
}
