package ThreadPool;

public class Money {
    public static volatile int money = 10000;
    public static Object lock = new Object();
}

class Thread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Money.lock) {
                if (Money.money != 10000) {
                    System.out.println("不是一万了");
                    break;
                }
            }
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        synchronized (Money.lock) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Money.money = 9000;
        }
    }
}