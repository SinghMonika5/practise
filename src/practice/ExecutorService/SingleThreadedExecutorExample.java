package practice.ExecutorService;

import java.util.concurrent.*;

public class SingleThreadedExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                try {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor.shutdown();
    }
}
