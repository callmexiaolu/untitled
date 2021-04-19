package main.syncdemo;

public class Resource {

    public synchronized void testSyncMethod1000_1() { //对普通方法加锁，锁对象为当前对象的方法引用
        System.out.println("进入了testSyncMethod1000_1" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "testSyncMethod1000_1running...time---" + System.currentTimeMillis() + "---object---" + this);
    }

    public synchronized void testSyncMethod1000_2() { //对普通方法加锁，锁对象为当前对象的方法引用
        System.out.println("进入了testSyncMethod1000_2" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "testSyncMethod1000_2running...time---" + System.currentTimeMillis() + "---object---" + this);
    }

    public synchronized static void testStaticSyncMethod200() { //对静态方法加锁，锁对象为当前对象的类引用
        System.out.println("进入了testStaticSyncMethod200" + System.currentTimeMillis());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "testStaticSyncMethod200 running...time---" + System.currentTimeMillis());
    }

    public synchronized static void testStaticSyncMethod1000() { //对静态方法加锁，锁对象为当前对象的类引用
        System.out.println("进入了testStaticSyncMethod1000" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "testStaticSyncMethod1 running...time---" + System.currentTimeMillis());
    }

    public void testNormal() { //普通方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "----testNormal1000---running...time---" + System.currentTimeMillis() + "---object---" + this);
    }

    public void testNormal200() { //普通方法
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "----testNormal200---running...time---" + System.currentTimeMillis() + "---object---" + this);
    }

    public void testSyncClass1000() { //锁对象为当前的类引用
        synchronized (Resource.class) {
            System.out.println("进入了testSyncClass1000" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----testSyncClass1000---running...time---" + System.currentTimeMillis() + "---object---" + this);
        }
    }

    public void testSyncClass200() { //锁对象为当前的类引用
        System.out.println("进入了testSyncClass200" + System.currentTimeMillis());
        synchronized (Resource.class) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----testSyncClass200---running...time---" + System.currentTimeMillis() + "---object---" + this);
        }
    }

    public void testLockThis1000() { //锁对象为当前的对象的方法引用
        System.out.println("进入了LockThis1000" + System.currentTimeMillis());
        synchronized (this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----testLockThis1000---running...time---" + System.currentTimeMillis() + "---object---" + this);
        }
    }

    public void testLockThis200() { //锁对象为当前的对象的方法引用
        System.out.println("进入了LockThis200" + System.currentTimeMillis());
        synchronized (this) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----testLockThis200---running...time---" + System.currentTimeMillis() + "---object---" + this);
        }
    }

}

