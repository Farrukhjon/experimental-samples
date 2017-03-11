package org.farrukh.experiments;

/**
 * Hello world!
 */
public class App {

    private final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> (100));

    private Integer data;

    public Integer getData() {
        return threadLocal.get();
    }

    public void setData(Integer data) {
        threadLocal.set(data);
    }

    public App() {

    }

    public static void main(String[] args) {

        Runnable calc = () -> {
            App app = new App();
            Integer data = app.getData();
            data++;
            app.setData(data);
            System.out.printf("Thread name: %s, the value is: %s \n", Thread.currentThread().getName(), app.getData());

        };

        new Thread(calc).start();
        new Thread(calc).start();
        new Thread(calc).start();

    }
}
