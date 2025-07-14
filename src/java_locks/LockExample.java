package java_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class LockExample {
    public static void main(String[] args) {
        /*
        DIFFERENCES BETWEEN SYNCHRONIZED AND REENTRANT
            1. Sync blocks must be contained within a single method.
            lock and unlock can be called from different methods.
            2. lock and unlock provides the same visibility and
            happens before guarantee as entering and exiting a sync block
            3. sync blocks are always reentrant, locks could decide not to be.
            4. Sync blocks do not guarantee fairness, locks can.

         */


        // switch fairness on
        // General locking approache
//        Lock lock = new ReentrantLock(true);
//
//        lock.lock();
//        // Do something
//        lock.unlock();

        Lock newLock = new ReentrantLock(false);
        Runnable runnable = () -> tryLock(newLock, 1000l);

        Thread th1 = new Thread(runnable, "Thread 1");
        Thread th2 = new Thread(runnable, "Thread 2");
        Thread th3 = new Thread(runnable, "Thread 3");

        th1.start();
        th3.start();
        th2.start();
    }

    private static void lockSleepUnlock(Lock lock, long time) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " holds the lock");
            sleepWithHandling(time);
        } finally {
            lock.unlock();
        }
    }


    private static void lockInterruptiblyUnlock(Lock lock, long time) {
        Thread.currentThread().interrupt();
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + " holds the lock");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } finally {
            lock.unlock();
        }
    }


    private static void tryLock(Lock lock, long time) {
        try {
            System.out.println(Thread.currentThread().getName()  + " Tried locking the lock, success ? : " + lock.tryLock());
            sleepWithHandling(time);
        }finally {
            try {
                lock.unlock();
            } catch (Exception e) {
                System.out.println("## WArning, unable to unlock lock: " + e);
            }
        }
    }

    private static void sleepWithHandling(long time) {
        try {
            sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
