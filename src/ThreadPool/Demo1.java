package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(
                ()->{
                    System.out.println(Thread.currentThread().getName() + "run");
                }
        );

        //Thread.sleep(2000);

        executorService.submit(
                ()->{
                    System.out.println(Thread.currentThread().getName() + "run");
                }
        );
        executorService.shutdown();
    }
}
