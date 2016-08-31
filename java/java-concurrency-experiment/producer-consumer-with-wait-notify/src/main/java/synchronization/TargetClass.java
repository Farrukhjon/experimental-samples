package synchronization;

/**
 * Created by Farrukhjon on 20-Sep-15.
 */
public class TargetClass {

    private int count = 0;

    public void call(int threadId) {
        System.out.println("thread id: " + threadId);
    }

    public void grow() {
        count++;
        printCount();
    }

    public void printCount() {
        System.out.println(count);
    }
}
