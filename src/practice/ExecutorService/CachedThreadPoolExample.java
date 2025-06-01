package practice.ExecutorService;

import java.util.concurrent.*;

class CTPDemo implements Runnable{

    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+" going for a sleep");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" up from a sleep");
        }catch (InterruptedException ex){

        }
    }
}


public class CachedThreadPoolExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0;i<10;i++){
            executorService.execute(new CTPDemo());
        }

        executorService.shutdown();
    }
}
