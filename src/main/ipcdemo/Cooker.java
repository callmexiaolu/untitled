package main.ipcdemo;

public class Cooker extends Thread{

    private Object dishes; //需要做的菜

    public Cooker(Object dishes) {
        this.dishes = dishes;
    }

    @Override
    public void run() {
        synchronized (dishes) {
            try {
                System.out.println("厨师做菜中ing----");
                Thread.sleep(4000);
                dishes.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("厨师做完菜了，服务员准备上菜-----");
        }
    }
}



