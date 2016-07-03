package synchronization;

public class UseCounter implements Runnable {

    public void increment() {
        synchronized (this) {
            Counter.count++;
            System.out.println(Thread.currentThread().getName() + " " + Counter.count + " ");
        }
    }

    public void run() {
        increment();
        increment();
        increment();
    }

    public static void main(String args[]) {
        UseCounter useCounter = new UseCounter();

        Thread t1 = new Thread(useCounter);
        Thread t2 = new Thread(useCounter);
        Thread t3 = new Thread(useCounter);

        t1.start();
        t2.start();
        t3.start();
    }

    public static class Counter {
        public static long count = 0;
    }
}
