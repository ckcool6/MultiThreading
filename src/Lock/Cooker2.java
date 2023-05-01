package Lock;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooker2 extends Thread {
    private ArrayBlockingQueue<String> list;
    public Cooker2(ArrayBlockingQueue<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                list.put("food");
                System.out.println("put food");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
