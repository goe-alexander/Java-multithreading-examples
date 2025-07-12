package thread_local_examples;

public class MainThreadLocalBasicExample {
    public static void main(String[] args) {
        var threadLocal = new ThreadLocal<String>();
        Thread th1 = new Thread(() -> {
            threadLocal.set("Thread 1");

            String firstValue = threadLocal.get();
            System.out.println(firstValue);

            threadLocal.remove();
            String newValue = threadLocal.get();
            System.out.println(newValue);


        });

        Thread th2 = new Thread(() -> {
            threadLocal.set("Thread 2");

            //Get value first Time
            String firstValue = threadLocal.get();
            System.out.println(firstValue);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Get value second time to show that the th1 removing it did not alter out variable.
            String secondValue = threadLocal.get();
            System.out.println(secondValue);

            threadLocal.remove();
            String newValue = threadLocal.get();
            System.out.println(newValue);


        });

        th1.start();
        th2.start();
    }
}
