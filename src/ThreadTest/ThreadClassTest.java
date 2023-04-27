package ThreadTest;

public class ThreadClassTest {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        Mythread t2 = new Mythread();
        t1.start();
        t2.start();
    }
}

class Mythread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程开启了" + i);
        }
    }
}
