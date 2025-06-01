package practice.semaphore;

class Semaphore {
    private int permits;

    public Semaphore(int initialPermits) {
        this.permits = initialPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permits == 0) {
            // Wait until permits are available
            wait();
        }
        permits--;
    }

    public synchronized void release() {
        permits++;
        notify();
    }
}
