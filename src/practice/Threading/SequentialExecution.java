package practice.Threading;
public class SequentialExecution {

    private static final int MAX_NUMBER = 10;
    private static int numberToPrint = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumbers(0));
        Thread t2 = new Thread(() -> printNumbers(1));
        Thread t3 = new Thread(() -> printNumbers(2));

        t1.start();
        t2.start();
        t3.start();
    }

    private static void printNumbers(int threadId) {
        while (numberToPrint <= MAX_NUMBER) {
            synchronized (SequentialExecution.class) {
                // Check if it's this thread's turn to print
                if (numberToPrint % 3 == threadId) {
                    System.out.println("Thread-" + (threadId + 1) + ": " + numberToPrint);
                    numberToPrint++;
                    // Notify other threads after printing
                    SequentialExecution.class.notifyAll();
                } else {
                    // If it's not this thread's turn, wait for other threads to print
                    try {
                        SequentialExecution.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
