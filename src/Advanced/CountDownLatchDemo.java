package Advanced;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        MotherThread motherThread = new MotherThread(countDownLatch);
        motherThread.start();

        ChildThread1 t1 = new ChildThread1(countDownLatch);
        t1.setName("lisi");
        ChildThread2 t2 = new ChildThread2(countDownLatch);
        t2.setName("zhangsan");
        ChildThread3 t3 = new ChildThread3(countDownLatch);
        t3.setName("wangwu");

        t1.start();
        t2.start();
        t3.start();

    }
}

class MotherThread extends Thread {
    private CountDownLatch countDownLatch;
    public MotherThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("收拾");
    }
}

class ChildThread1 extends Thread {
    private CountDownLatch countDownLatch;
    public ChildThread1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "在吃第" + i + "个");
        }
        countDownLatch.countDown();
    }
}

class ChildThread2 extends Thread {
    private CountDownLatch countDownLatch;
    public ChildThread2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println(getName() + "在吃第" + i + "个");
        }
        countDownLatch.countDown();
    }
}
class ChildThread3 extends Thread {
    private CountDownLatch countDownLatch;
    public ChildThread3(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + "在吃第" + i + "个");
        }
        countDownLatch.countDown();
    }
}