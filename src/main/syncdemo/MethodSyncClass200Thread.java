package main.syncdemo;

//线程4-调用 synchronized static方法
public class MethodSyncClass200Thread extends Thread {

    private Resource syncMethodTest;

    public MethodSyncClass200Thread(Resource syncMethodTest) {
        this.syncMethodTest = syncMethodTest;
    }

    @Override
    public void run() {
        syncMethodTest.testSyncClass200();
    }
}