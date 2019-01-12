package synchronization;

public class MyThread extends Thread {

    private int threadId;
    private TargetClass target;

    public MyThread(int threadId, TargetClass target) {
        this.threadId = threadId;
        this.target = target;
    }

    @Override
    public void run() {
        synchronized (target) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            target.call(threadId);
            target.grow();
        }
    }

}
