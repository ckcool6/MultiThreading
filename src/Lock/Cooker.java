package Lock;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooker extends Thread {
    private Desk desk;
    public Cooker(Desk desk) {
        this.desk=desk;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (desk.getLock()) {
                if (desk.getCount() == 0){
                    break;
                }else {
                    if (!desk.isFlag()){
                        System.out.println("make");
                        desk.setFlag(true);
                        desk.getLock().notifyAll();
                    }else {
                        try {
                            desk.getLock().wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
