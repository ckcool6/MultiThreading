package Lock;

public class DeadLock {
    public static void main(String[] args) {
        Object objA = new Object();
        Object objB = new Object();

        new Thread(()->{
            while (true){
                synchronized (objA){
                    synchronized (objB){
                        System.out.println("Arunning");
                    }
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                synchronized (objB){
                    synchronized (objA){
                        System.out.println("Brunning");
                    }
                }
            }
        }).start();
    }
}
