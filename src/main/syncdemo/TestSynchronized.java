package main.syncdemo;

public class TestSynchronized {

    private volatile static TestSynchronized singleton;

    public static volatile int i = 0;

    public static TestSynchronized getInstance() {
        if (singleton == null) {
            synchronized (TestSynchronized.class) {
                if (singleton == null) {
                    singleton = new TestSynchronized();
                }
            }
        }
        return singleton;
    }

    public TestSynchronized() {
        System.out.println("进入TestSynchronized构造方法" + this);
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        Resource resource1 = new Resource();
        //访问synchronized方法，sleep1000ms

        //访问synchronized方法，sleep1000ms
        Thread t2 = new MethodSyncMethod1000_2Thread(resource);
        //访问synchronized static方法，sleep1000ms
        Thread t3 = new MethodSyncStatic1000Thread(resource);
        //访问synchronized static方法，sleep200ms
        Thread t4 = new MethodSyncStatic200Thread(resource);
        //访问synchronized static方法，sleep200ms
        Thread t6 = new MethodSyncStatic200Thread(resource1);
        //访问synchronized方法，sleep1000ms
        Thread t5 = new MethodSyncMethod1000_2Thread(resource1);
        //访问普通方法，sleep1000ms



        //todo 测试synchronized修饰普通方法
        /**
         * synchronized修饰普通方法，锁对象是当前实例
         */
        Thread syncMethod1   = new MethodSyncMethod1000_1Thread(resource);
        Thread syncMethod1_1 = new MethodSyncMethod1000_1Thread(resource1);
        Thread syncMethod2   = new MethodSyncMethod1000_1Thread(resource);
        Thread syncMethod3   = new MethodSyncMethod1000_2Thread(resource);
        Thread t1            = new MethodNormalThread(resource1);
        //如果访问方法不同，但是使用的实例是一致的，那么需要先获取锁，因此不会同时输出
        //syncMethod1.start();
        //syncMethod3.start();
        //如果使用的实例不同，那么会同时输出
        //syncMethod1.start();
        //syncMethod1_1.start();
        //如果使用的实例一致，方法一致，那么要先阻塞获取锁，不存在同时输出
        //syncMethod1.start();
        //syncMethod2.start();
        //使用的实例一致，同时访问普通方法和synchronized修饰的方法，同时输出，因为普通方法不需要获取锁
        //t1.start();
        //syncMethod1_1.start();


        //todo 测试synchronized修饰object对象
        /**
         * 对同一个实例的访问，synchronized修饰该实例，然后访问普通的方法
         * 由于synchronized修饰实例，因此线程代码块运行完毕释放锁才到下一个使用该实例的线程运行代码块
         *
         * 总结:不同实例不竞争锁、相同实例相同方法竞争锁、相同实例不同方法(加锁了的)竞争锁
         */
        Thread syncObj1 = new SyncObject1000Thread(resource);
        Thread syncObj2 = new SyncObject1000Thread(resource);
        Thread syncLockThis = new MethodSyncThis1000Thread(resource);
        //syncMethod1.start();
        //syncLockThis.start();
        //syncObj1.start();
        //syncObj2.start();
        /**
         * synchronized修饰实例，但是这里我们传递进去的实例不同，所以锁对象不一样，所以不存在阻塞，因此同时输出
         */

        //Thread syncObj2 = new SyncObject1000Thread(resource);
        //syncObj1.start();
        //syncObj2.start();


        //todo 测试synchronized修饰.class
        /**
         * synchronized修饰Resource.class，锁对象为常量池的类引用
         * 所以无论这里传递进去的实例是否一致，都不会同时输出。
         * 因为锁对象是常量池中Resource.class的类引用，是唯一的。所以其他线程必须等待锁释放才能访问
         */
        Thread syncClass1 = new MethodSyncClass1000Thread(resource);
        Thread syncClass2 = new MethodSyncClass1000Thread(resource1);

        /**
         * 使用相同实例，一个修饰.class，一个object两个同时输出，说明对象锁和类锁不同，
         */
        //syncObj1.start();
        //syncClass1.start();
        //syncMethod1.start();
        //syncClass2.start();


        //todo 测试synchronized修饰static方法
        /**
         * 对类内的静态方法加锁，锁对象为
         *
         * 如果使用不同实例
         * 使用相同实例，分别调用static方法和实例的普通方法/sync修饰的方法，同时输出，说明锁对象不是object和.class
         */
        Thread syncStatic1 = new MethodSyncStatic1000Thread(resource);
        Thread syncStatic2 = new MethodSyncStatic1000Thread(resource);
        Thread normalMethod1 = new MethodNormalThread(resource);

        //syncStatic1.start();
        //syncMethod1.start();
        //normalMethod1.start();
        //syncClass1.start();
        //syncStatic2.start();

        //todo 测试synchronized修饰方法内的this关键字
        Thread lockThis1 = new MethodSyncThis1000Thread(resource);
        Thread lockThis2 = new MethodSyncThis1000Thread(resource1);
        Thread lockThis3 = new MethodSyncThis1000Thread(resource);

        /**
         * 不同对象:
         * this和this---同时进入同时输出
         * 锁static和class---同时进入，先输出static，后输出class
         * 锁object和static---同时进入同时输出
         */
        //lockThis1.start();
        //syncObj2.start();
        //syncStatic1.start();

        //syncClass2.start();
        //lockThis2.start();
        /**
         * 相同对象，相同方法---同时进入，先后分别输出
         */
        //lockThis1.start();
        //lockThis3.start();
        /**
         * 相同对象:
         * 锁class和this----同时进入同时输出
         * 锁object和this---同时进入，先输出object，后输出this
         * 锁method和this---同时进入，先输出syncMethod，后输出this
         * 锁static和this---同时进入，同时输出
         * 锁method和object---先进入method，输出method，再进入object，再输出object
         * 锁method和class---同时进入，同时输出
         * 锁method和static---同时进入，同时输出
         * 锁object和class---同时进入，同时输出
         * 锁object和static---同时进入，同时输出
         * 锁object和method---先进入method，输出method，再进入object，再输出object
         * 锁static和class---同时进入，先输出static，后输出class
         */
        //syncClass1.start();
        //syncMethod1.start();
        //syncStatic1.start();
        //lockThis1.start();
        //syncObj1.start();
        //syncObj2.start();

    }

}
