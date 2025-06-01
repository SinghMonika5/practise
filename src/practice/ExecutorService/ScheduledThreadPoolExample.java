package practice.ExecutorService;

import java.util.concurrent.*;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }, 0, 1, TimeUnit.SECONDS);
        
        // Allow some time for scheduling
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}
