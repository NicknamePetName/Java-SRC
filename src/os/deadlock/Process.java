package os.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class Process {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });

        t1.start();
        t2.start();

        // 检测死锁
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] threadIds = bean.findDeadlockedThreads();
        if (threadIds != null) {
            System.out.println("Deadlock detected:");
            // for (long threadId : threadIds) {
            //     for (Thread thread : Thread.getAllStackTraces().keySet()) {
            //         if (thread.getId() == threadId) {
            //             System.out.println(thread.getName() + " is deadlocked.");
            //             thread.interrupt(); // 终止进程
            //         }
            //     }
            // }
        } else {
            System.out.println("No deadlock detected.");
            // 找到一个安全序列
        }
    }
}
