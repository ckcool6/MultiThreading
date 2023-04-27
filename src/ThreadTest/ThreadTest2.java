package ThreadTest;

public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("jk001");
        MyThread2 t2 = new MyThread2("jk002");

        t1.start();
        t2.start();
    }
}

class MyThread2 extends Thread {
    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + "@@@" + i);
        }
    }
}
