package communication.ch2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProducerTask implements Runnable {

    private Data mutex;

    public ProducerTask(Data mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(2);
                synchronized (mutex) {
                    mutex.setValue(" " + new Date());
                    System.out.println("Producer: Setting value to: " + mutex.getValue());
                    mutex.notify();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Producer task has been interrupted");
            return;
        }
    }

}
