package Lock;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //method1();
        ArrayBlockingQueue<String> list = new ArrayBlockingQueue<>(1);

        Cooker2 c = new Cooker2(list);
        Foodie2 f = new Foodie2(list);

        c.start();
        f.start();
    }

    private static void method1() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

        arrayBlockingQueue.put("food");

        String result = arrayBlockingQueue.take();
        String result2 = arrayBlockingQueue.take();

        System.out.println(result);
        System.out.println(result2);
    }
}
