package Lock;

public class TicketDemoTest {
    public static void main(String[] args) {
        //method1();
        //method();
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();

    }

    private static void method() {
        Ticket2 t1 = new Ticket2();
        Ticket2 t2 = new Ticket2();

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }

    private static void method1() {
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
