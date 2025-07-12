package thread_local_examples;

public class MainInheritableThreadLocal {
    public static void main(String[] args) {
        var threadLocal = new ThreadLocal<String>();
        var inheritableThreadLocal = new InheritableThreadLocal<>();

        var th1 = new Thread(() -> {
            System.out.println("==========Thread 1==========");
            threadLocal.set("Thread 1- thread local");
            inheritableThreadLocal.set("Thread 1 - inheritableThreadLocal");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println("===== ChildThread =====");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });
            childThread.start();
        });

        th1.start();

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("===== Thread2 =====");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        });
        thread2.start();

    }
}
