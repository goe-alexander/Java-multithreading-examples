package synchronized_examples;

import runnable_examples.MyMemoryRunnable;

public class MainSharedObject {
    public static void main(String[] args) {
        Runnable runnable = new MyMemoryRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }
}
