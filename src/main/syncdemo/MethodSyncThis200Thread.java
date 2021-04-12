package main.syncdemo;

public class MethodSyncThis200Thread extends Thread{

    private Resource resource;

    public MethodSyncThis200Thread(Resource syncMethodTest) {
        this.resource = syncMethodTest;
    }

    @Override
    public void run() {
        resource.testLockThis200();
    }
}
