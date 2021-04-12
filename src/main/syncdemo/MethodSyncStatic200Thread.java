package main.syncdemo;

public class MethodSyncStatic200Thread extends Thread {

    private Resource resource;

    public MethodSyncStatic200Thread(Resource syncMethodTest) {
        this.resource = syncMethodTest;
    }

    @Override
    public void run() {
        Resource.testStaticSyncMethod200();
    }
}
