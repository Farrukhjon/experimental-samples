package communication.ch2;

import java.util.concurrent.TimeUnit;

public class ConsumerTask implements Runnable {

    private Data mutex;

    public ConsumerTask(Data mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        try {
            String mostRecentValue = null;
            while (true) {
                synchronized (mutex) {
                    if (mutex.getValue() == mostRecentValue) {
                        System.out.println("Consumer: Waiting for new value");
                        mutex.wait();
                        System.out.println("Consumer: Producer woke me up!");
                    } else {
                        System.out.println("Consumer: There's a new value waiting for me");
                    }
                    mostRecentValue = mutex.getValue();
                    System.out.println("Consumer take value: " + mostRecentValue);
                    TimeUnit.SECONDS.sleep(2);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer task has been interrupted");
            return;
        }
    }

}
