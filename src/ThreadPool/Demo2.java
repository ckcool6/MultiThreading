package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Demo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10); //最大值
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
        System.out.println(pool.getPoolSize()); //0

        executorService.submit(
                () -> {
                    System.out.println(Thread.currentThread().getName() + "run");
                }
        );
        executorService.submit(
                () -> {
                    System.out.println(Thread.currentThread().getName() + "run");
                }
        );
        System.out.println(pool.getPoolSize());
        executorService.shutdown();
    }
}
