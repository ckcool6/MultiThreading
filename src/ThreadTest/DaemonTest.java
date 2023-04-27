package ThreadTest;

public class DaemonTest {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.setName("Normal");
        t2.setName("Protect");

        t2.setDaemon(true); //设置守护线程

        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + "---" + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + "---" + i);
        }
    }
}