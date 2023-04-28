//锁对象唯一
package Lock;

public class Ticket2 extends Thread {
    private static int ticketCount = 100;
    private static final Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticketCount <= 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticketCount--;
                    System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticketCount + "张票");
                }
            }
        }
    }
}
