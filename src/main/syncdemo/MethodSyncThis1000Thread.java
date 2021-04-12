package main.syncdemo;

public class MethodSyncThis1000Thread extends Thread {

    private Resource resource;

    public MethodSyncThis1000Thread(Resource syncMethodTest) {
        this.resource = syncMethodTest;
    }

    @Override
    public void run() {
        resource.testLockThis1000();
    }
}
