package org.farrukh.experiments.java.thread;

import java.io.Serializable;

public class ThreadInConstructor {

    public ThreadInConstructor() throws InterruptedException {

        Thread t1 = new Thread(new ClassForT1());
        t1.start();
        Thread t2 = new Thread(new ClassForT2());
        t2.start();
    }

    public static void main(String[] args) {
        try {
            new ThreadInConstructor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class ClassForT2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("Class For T2 " + ClassForT1.getInstance().getInfo());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static class ClassForT1 implements Runnable, LinkerTwoClass, Serializable {

        private static final long serialVersionUID = 1L;

        private String info = new String("ds");

        private static ClassForT1 instance;

        @Override
        public void run() {
            while (true) {
                System.out.println("Class For T1");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (info) {
                    info += "info from T1";
                    info.notify();
                }
            }
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public static ClassForT1 getInstance() {
            return (instance == null) ? instance = new ClassForT1() : instance;
        }
    }

    public static interface LinkerTwoClass {

        String getInfo();
    }
}
