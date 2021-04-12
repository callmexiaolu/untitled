package main.syncdemo;

public class SyncObject200Thread extends Thread {
    private Resource resource;

    public SyncObject200Thread(Resource syncMethodTest) {
        this.resource = syncMethodTest;
    }

    @Override
    public void run() {
        System.out.println("进入SyncObject200Thread--run--synchronized-before" + System.currentTimeMillis());
        synchronized (resource) {
            System.out.println("进入SyncObject200Thread--run--synchronized-after" + System.currentTimeMillis());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----SyncObject200---running...time---" + System.currentTimeMillis() + "---object---" + resource);
        }
    }
}
