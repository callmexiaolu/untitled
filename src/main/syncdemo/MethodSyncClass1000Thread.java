package main.syncdemo;

//线程3-调用 synchronized static方法
public class MethodSyncClass1000Thread extends Thread {

    private Resource syncMethodTest;

    public MethodSyncClass1000Thread(Resource syncMethodTest) {
        this.syncMethodTest = syncMethodTest;
    }

    @Override
    public void run() {
        syncMethodTest.testSyncClass1000();
    }
}
