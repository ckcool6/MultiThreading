package Advanced;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        for (int i = 0; i < 100; i++) {
            new Thread(mr).start();
        }
    }
}

class MyRunnable implements Runnable{
    private final Semaphore semaphore = new Semaphore(2);
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("获得通行证");
            Thread.sleep(2000);
            System.out.println("归还通行证");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}