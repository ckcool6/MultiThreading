package Advanced;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomThread implements Runnable {
    //private volatile int count = 0;
    //private final Object lock = new Object();
    AtomicInteger ac = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //synchronized (lock) {
            int count = ac.incrementAndGet();
            System.out.println("send" + count + "things");
            //}
        }
    }
}
