package ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadTest4 {
    public static void main(String[] args) {
        MyCallable2 mc = new MyCallable2();
        FutureTask<String> ft = new FutureTask<>(mc);

        Thread t1 = new Thread(ft);
        t1.setName("Plane");
        t1.setPriority(10);    //设置优先级
        //System.out.println(t1.getPriority()); //优先级
        t1.start();

        MyCallable2 mc2 = new MyCallable2();
        FutureTask<String> ft2 = new FutureTask<>(mc2);

        Thread t2 = new Thread(ft2);
        t2.setName("Tank");
        //System.out.println(t2.getPriority());
        t2.start();
    }
}

class MyCallable2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
        return "DOWN";
    }
}
