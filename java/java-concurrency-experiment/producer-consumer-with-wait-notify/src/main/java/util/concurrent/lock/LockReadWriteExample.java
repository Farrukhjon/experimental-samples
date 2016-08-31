package util.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Farrukhjon on 20-Sep-15.
 */
public class LockReadWriteExample {

    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo();

        Thread readerThread = new Thread(new PriceReader(priceInfo));
        Thread writerThread = new Thread(new PriceWriter(priceInfo));

        writerThread.start();
        readerThread.start();

    }

    private static class PriceInfo {
        private double wholesalePrice;
        private double retailPrice;

        private final ReadWriteLock readWriteLock;

        public PriceInfo() {
            this.readWriteLock = new ReentrantReadWriteLock();
        }

        public double getWholesalePrice() {
            readWriteLock.readLock().lock();
            double value = wholesalePrice;
            readWriteLock.readLock().unlock();
            return value;
        }

        public double getRetailPrice() {
            readWriteLock.readLock().lock();
            double value = retailPrice;
            readWriteLock.readLock().unlock();
            return value;
        }

        public void setWholesalePrice(double wholesalePrice) {
            readWriteLock.writeLock().lock();
            double value = wholesalePrice;
            this.wholesalePrice = value;
            readWriteLock.writeLock().unlock();
        }

        public void setRetailPrice(double retailPrice) {
            readWriteLock.writeLock().lock();
            double value = retailPrice;
            this.retailPrice = value;
            readWriteLock.writeLock().unlock();
        }
    }

    private static class PriceReader implements Runnable {

        private final PriceInfo priceInfo;

        public PriceReader(PriceInfo priceInfo) {
            this.priceInfo = priceInfo;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Reading a wholesalePrice from: " + Thread.currentThread().getName() + priceInfo.getWholesalePrice());
                System.out.println("Reading a retailPrice from: " + Thread.currentThread().getName() + priceInfo.getRetailPrice());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class PriceWriter implements Runnable {

        private final PriceInfo priceInfo;

        public PriceWriter(PriceInfo priceInfo) {
            this.priceInfo = priceInfo;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Writing a whole sale price by: " + Thread.currentThread().getName());
                priceInfo.setWholesalePrice(Math.random() * 5);

                System.out.println("Writing a whole retail price: " + Thread.currentThread().getName());
                priceInfo.setRetailPrice(Math.random() * 10);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
