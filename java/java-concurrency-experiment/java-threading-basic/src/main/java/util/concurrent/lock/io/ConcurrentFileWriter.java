package util.concurrent.lock.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentFileWriter implements Runnable {

    private File file;
    private List<PersonData> persons;
    private PersonData person;
    private boolean isFinished;

    public ConcurrentFileWriter(final File file) {
        this.file = file;
    }

    public ConcurrentFileWriter(final File file, final List<PersonData> persons) {
        this.file = file;
        this.persons = persons;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            write(person);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void write(final PersonData p) {
        Lock lock = new ReentrantLock();
        BufferedWriter bufferedWriter = null;
        try {
            try {
                lock.lock();
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(p.getFirstName());
                bufferedWriter.write("\t");
                bufferedWriter.write(String.valueOf(p.getAge()));
                bufferedWriter.write("\t");
                bufferedWriter.write(Thread.currentThread().getName());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } finally {
            /*try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }

    public void setPerson(final PersonData p) {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            this.person = p;
        } finally {
            lock.unlock();
        }
    }
}
