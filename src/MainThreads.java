import runnable_examples.CountDownTimer;
import runnable_examples.ThreadExample;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainThreads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i <=3; i++) {
            ThreadExample threadExample = new ThreadExample(i);
            threadExample.start();
        }
        //Testing generic runnable countDownTimer
        Runnable runnableCountdown = new CountDownTimer(3);
        Thread thread = new Thread(runnableCountdown);
        thread.start();
        thread.join();

        Runnable runnableLambda = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": Lambda Running");
                System.out.println("Lambda Finished");
            }

        };
        Thread th = new Thread(runnableLambda);
        th.setDaemon(true);
        th.start();

//        //Testing generic Executor service
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//
//        executor.submit(new MessagePrinterTask("Hello from task 1", 5));
//        executor.submit(new MessagePrinterTask("Hello from task 2", 5));
//
//        executor.shutdown();
//
//        // Testing callable
//        ExecutorService executorCached = Executors.newCachedThreadPool();
//        Future<Integer> futureResult = executorCached.submit(new WordLengthCallable("Helllo!"));
//        System.out.println("Word length: " + futureResult.get());
//        executorCached.shutdown();
    }
}