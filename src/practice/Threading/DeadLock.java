package practice.Threading;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadLock {
	
		public static void main(String[] args)   {

			// TO PREVENT THIS DEADLOCK CONDITION
			//WE CAN LOCK OBJECTS IN SAME SEQUENCE IN BOTH THREADS INSTEAD OF CYCLE
			Object lock1 = new Object();
			Object lock2 = new Object();
			
			Thread thread1 = new Thread(()->{
					synchronized (lock1) {
					System.out.println("Locked Object lock1 : "+Thread.currentThread().getName());
					try {
						Thread.sleep(2000);
					}catch(Exception exc) {}
					
					synchronized (lock2) {
					System.out.println("Locke Object lock2 : "+Thread.currentThread().getName());
					}
					}
				});

			Thread thread2 = new Thread() {
				public void run() {
					synchronized (lock2) {
					System.out.println("Locked Object lock2 : "+Thread.currentThread().getName());
					try {
						Thread.sleep(2000);
					}catch(Exception exc) {}
					synchronized (lock1) {
					System.out.println("Locked Object lock1 : "+Thread.currentThread().getName());
					}
					}
				}
			};

			thread1.start();
			thread2.start();

			ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

			while (true) {
				long[] threadIds = threadMXBean.findDeadlockedThreads();

				if (threadIds != null) {
					System.out.println("Deadlock detected!");

					ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
					for (ThreadInfo threadInfo : threadInfos) {
						System.out.println("Thread " + threadInfo.getThreadName() + " is deadlocked.");
						for (StackTraceElement stackTrace : threadInfo.getStackTrace()) {
							System.out.println("  " + stackTrace);
						}
					}
				}

				try {
					Thread.sleep(5000); // Check for deadlocks every 5 seconds
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}

		}
}