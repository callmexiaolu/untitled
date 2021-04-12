package main.syncdemo;

public class MethodNormalThread extends Thread {

    private Resource syncMethodTest;

    public MethodNormalThread(Resource syncMethodTest) {
        this.syncMethodTest = syncMethodTest;
    }

    @Override
    public void run() {
        syncMethodTest.testNormal();
    }
}
