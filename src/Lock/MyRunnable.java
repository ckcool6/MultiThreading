package Lock;

public class MyRunnable implements Runnable {
    private static int ticketCount = 100;

    @Override
    public void run() {
        while (true) {
            if ("窗口一".equals(Thread.currentThread().getName())) {
                boolean result = false;
                try {
                    result = synchronizedMethod();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (result) {
                    break;
                }
            }
            if ("窗口二".equals(Thread.currentThread().getName())) {
                //
                synchronized (MyRunnable.class) {
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

    private static synchronized boolean synchronizedMethod() throws InterruptedException {
        if (ticketCount == 0) {
            return true;
        } else {
            Thread.sleep(100);
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticketCount + "张票");
            return false;
        }
    }
}
