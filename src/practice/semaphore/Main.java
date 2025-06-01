package practice.semaphore;

class Worker implements Runnable {
    private Semaphore semaphore;
    private int id;

    public Worker(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            // Acquire a permit from the semaphore
            semaphore.acquire();

            // Perform some work
            System.out.println("Worker " + id + " is performing work");

            // Simulate work by sleeping for some time
            Thread.sleep(2000);

            // Release the permit back to the semaphore
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int numWorkers = 3;
        Semaphore semaphore = new Semaphore(1);

        // Create worker threads
        Thread[] workers = new Thread[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            workers[i] = new Thread(new Worker(semaphore, i));
            workers[i].start();
        }

        // Wait for all worker threads to complete
        for (int i = 0; i < numWorkers; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
