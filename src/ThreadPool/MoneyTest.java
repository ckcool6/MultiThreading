package ThreadPool;

public class MoneyTest {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.setName("lisi");
        t1.start();

        Thread2 t2 = new Thread2();
        t2.setName("zhangsan");
        t2.start();
    }
}
