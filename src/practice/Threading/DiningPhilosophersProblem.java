package practice.Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosopher extends Thread {
    private final Lock leftFork;
    private final Lock rightFork;
    private final int philosopherNumber;

    public Philosopher(int philosopherNumber, Lock leftFork, Lock rightFork) {
        this.philosopherNumber = philosopherNumber;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + philosopherNumber + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + philosopherNumber + " is eating.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                leftFork.lock();
                System.out.println("Philosopher " + philosopherNumber + " picks up left fork.");
                rightFork.lock();
                System.out.println("Philosopher " + philosopherNumber + " picks up right fork.");

                eat();

                rightFork.unlock();
                System.out.println("Philosopher " + philosopherNumber + " puts down right fork.");
                leftFork.unlock();
                System.out.println("Philosopher " + philosopherNumber + " puts down left fork.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class DiningPhilosophersProblem {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Lock[] forks = new Lock[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new ReentrantLock();
        }

        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            Lock leftFork = forks[i];
            Lock rightFork = forks[(i + 1) % numPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            philosophers[i].start();
        }
    }
}
