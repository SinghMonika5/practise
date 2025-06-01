package practice.Threading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource {
    private int data = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public int read() {

        //MULTIPLE THREADS CAN ACCESS THIS AREA
        lock.readLock().lock();
        try {
            Thread.sleep(1000);
            return data;

        }catch(InterruptedException ex){return 0;}finally {
            lock.readLock().unlock();
        }
    }

    public void increment() {
        //ONLY ONE THREAD CAN ACCESS THIS AREA
        lock.writeLock().lock();
        try {
            data++;
            Thread.sleep(2000);
        }catch (InterruptedException ex){}finally {
            lock.writeLock().unlock();
        }
    }
}

class Reader extends Thread {
    private SharedResource resource;

    public Reader(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int data = resource.read();
            System.out.println("Reader: " + Thread.currentThread().getName() + " read: " + data);
        }
    }
}

class Writer extends Thread {
    private SharedResource resource;

    public Writer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.increment();
            System.out.println("Writer: " + Thread.currentThread().getName() + " incremented data.");
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        for (int i = 0; i < 3; i++) {
            new Reader(resource).start();
        }

        for (int i = 0; i < 2; i++) {
            new Writer(resource).start();
        }
    }
}
