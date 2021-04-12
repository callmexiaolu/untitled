package main.syncdemo;

public class MethodSyncStatic1000Thread extends Thread {
    private Resource resource;

    public MethodSyncStatic1000Thread(Resource syncMethodTest) {
        this.resource = syncMethodTest;
    }

    @Override
    public void run() {
        Resource.testStaticSyncMethod1000();
    }
}
