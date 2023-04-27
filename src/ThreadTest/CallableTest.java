package ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft);

        t1.start();
        String s = ft.get();
        System.out.println(s);
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("第" + i);
        }
        return null;
    }
}
