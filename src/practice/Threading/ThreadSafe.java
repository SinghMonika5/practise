package practice.Threading;


import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private int count = 0;

    public void increment() {
        count = count + 1; // Read and write operation
    }

    public int getCount() {
        return count; // Read operation
    }
}


class SafeCounter {
    private AtomicInteger count = new AtomicInteger(0);


    public void increment() {
        count.incrementAndGet(); // Atomic operation, no race condition
    }

    public int getCount() {
        return count.get(); // Atomic operation, no race condition
    }
}




public class ThreadSafe {

    public static void main(String[] args) {
        //        Counter counter = new Counter();
        SafeCounter counter = new SafeCounter();


        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.increment();
                System.out.println("T2 : "+counter.getCount());
            }

        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.increment();
                System.out.println("T1 : "+counter.getCount());
            }

        });

        t1.start();
        t2.start();
    }
}
