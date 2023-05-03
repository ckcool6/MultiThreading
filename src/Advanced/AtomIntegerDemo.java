package Advanced;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger ac = new AtomicInteger(10);

        System.out.println(ac.get());
        System.out.println(ac.getAndIncrement()); //自增前的值
        System.out.println(ac.incrementAndGet()); //自增后的值
        System.out.println(ac.addAndGet(20));
        System.out.println(ac.getAndSet(20));

    }
}
