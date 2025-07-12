package synchronized_examples;

import runnable_examples.MyMemoryRunnable;

public class MainSeparateObject {

    public static void main(String[] args) {
        Runnable runnable1 = new MyMemoryRunnable();
        Runnable runnable2 = new MyMemoryRunnable();

        Thread thread1 =
                new Thread(runnable1);

        Thread thread2 =
                new Thread(runnable2);


        thread1.start();
        thread2.start();
    }
}
