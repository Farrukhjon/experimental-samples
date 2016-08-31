package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Farrukhjon on 23-Sep-15.
 */
public class InterruptingUsingInterruptedMethodExample {

    public static void main(String[] args) throws InterruptedException {

        ThreadUsesInterruptedMethod someThread = new ThreadUsesInterruptedMethod();
        someThread.start();
        TimeUnit.SECONDS.sleep(3); // sleep for 3 second and then interrupt someThread
        someThread.interrupt();

    }

    private static class ThreadUsesInterruptedMethod extends Thread {

        @Override
        public void run() {
            for (int i = 1; i <= 999999; i++) {
                if (interrupted()) {
                    System.out.println(getName() + " now is interrupted ");
                    return;
                }
                System.out.println(getName() + " is not interrupted " + i);
            }
        }
    }

}
