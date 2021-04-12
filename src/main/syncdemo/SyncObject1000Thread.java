package main.syncdemo;

public class SyncObject1000Thread extends Thread{
    private Resource resource;

    public SyncObject1000Thread(Resource syncMethodTest) {
        this.resource = syncMethodTest;
    }

    @Override
    public void run() {
        System.out.println("进入SyncObject1000Thread--run--synchronized-before" + System.currentTimeMillis());
        synchronized (resource) {
            System.out.println("进入SyncObject1000Thread--run--synchronized-after" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----SyncObject1000---running...time---" + System.currentTimeMillis()+ "---object---" + resource);
        }
    }
}
