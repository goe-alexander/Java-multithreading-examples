package thread_local_examples;

public class MainThreadLocalInitialValue {

    public static void main(String[] args) {
        var threadLocal = ThreadLocal.withInitial(() -> "MY FIRST THREAD DEFAULT");

        Thread th1 = new Thread(() -> {
            String firstValue = threadLocal.get();
            System.out.println(firstValue);

            threadLocal.set("Thread 1");

            String secondValue = threadLocal.get();
            System.out.println(secondValue);

            threadLocal.remove();
            String newValue = threadLocal.get();
            System.out.println(newValue);


        });

        Thread th2 = new Thread(() -> {


            //Get value first Time
            String firstValue = threadLocal.get();
            System.out.println(firstValue);
            threadLocal.set("Thread 2");
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
