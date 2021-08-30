package main.ipcdemo;

public class Waiter extends Thread{

    private Object dishes; //需要上的菜

    public Waiter(Object dishes) {
        this.dishes = dishes;
    }

    @Override
    public void run() {
        synchronized (dishes) {
            try {
                System.out.println("菜没做好，服务员等待厨师通知-------");
                dishes.wait();
                System.out.println("收到厨师的通知，菜做好了，进行上菜----");
                Thread.sleep(2000);
                System.out.println("服务员上菜完毕----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
