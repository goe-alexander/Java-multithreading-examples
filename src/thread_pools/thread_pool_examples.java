package thread_pools;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class thread_pool_examples {
    public static void main(String[] args) {
//        var threadPool = new ThreadPool(3, 10);
        var threadPoolExecutor = Executors.newFixedThreadPool(2);
        for(int i =0; i<10; i++) {
            int taskNo = i;
            threadPoolExecutor.submit(() -> {
                var message = Thread.currentThread().getName() + ": Task " + taskNo;
                System.out.println(message);
            });
        }

        System.out.println("Is thread still executing ? : " + threadPoolExecutor.isShutdown());
        threadPoolExecutor.shutdown();
    }
}
