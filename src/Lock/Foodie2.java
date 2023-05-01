package Lock;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie2 extends Thread {
    private ArrayBlockingQueue<String> list;

    public Foodie2(ArrayBlockingQueue<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String take = null;
        while (true) {
            try {
                take = list.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("get" + take);
        }
    }
}
