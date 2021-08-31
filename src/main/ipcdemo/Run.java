package main.ipcdemo;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadSubTract threadSubTract = new ThreadSubTract(subtract);
        threadSubTract.setName("threadSub1");
        threadSubTract.start();

        ThreadSubTract threadSubTract2 = new ThreadSubTract(subtract);
        threadSubTract2.setName("threadSub2");
        threadSubTract2.start();

        Thread.sleep(1000);

        ThreadAdd addThread = new ThreadAdd(add);
        addThread.setName("addThread");
        addThread.start();

    }
}
