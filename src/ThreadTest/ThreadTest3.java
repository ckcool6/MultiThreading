package ThreadTest;

public class ThreadTest3 {
    public static void main(String[] args) throws InterruptedException {
        //method1();
        /*
        System.out.println("before");
        Thread.sleep(3000); //等待三秒
        System.out.println("after");
        */

        MyRunnable2 mr = new MyRunnable2();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.start();
        t2.start();
    }

    private static void method1() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}

class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
