package ThreadTest;

public class RunnableTest {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        MyRunnable mr2 = new MyRunnable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr2);

        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}