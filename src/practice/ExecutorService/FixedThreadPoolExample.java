package practice.ExecutorService;

import java.util.concurrent.*;

public class FixedThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 5; i++) {
            int a = i;
            Future f= executor.submit(() -> {
                try {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return a;

            });

            System.out.println(f.get());

        }
        executor.shutdown();
    }
}
