package practice.Threading;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1");
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2");
        });

        Thread t3 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 3");
        });




        t1.start();
        t1.join(1000);
        t2.start();
        t2.join(1000);
        t3.start();


    }



}
