package main.syncdemo;

//线程2-调用 synchronized方法
public class MethodSyncMethod1000_2Thread extends Thread {

    private Resource resource;

    public MethodSyncMethod1000_2Thread(Resource syncMethodTest) {
        this.resource = syncMethodTest;
    }

    @Override
    public void run() {
        resource.testSyncMethod1000_2();
    }
}
