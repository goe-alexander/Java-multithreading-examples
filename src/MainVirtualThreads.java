import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MainVirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("## Testing virtual threads");

        Runnable runnable = () -> {
            final var threadId = Thread.currentThread().threadId();
            for (int i = 0; i < 10; i++) {
                System.out.println("From Thread: " + threadId + "Index: " + i);
            }
        };

//        //Started Virtual Thread
//        Thread vThread1 = Thread.ofVirtual().start(runnable);
//
//
//        //Unstarted Virtual Thread
//        Thread vThread2 = Thread.ofVirtual().unstarted(runnable);
//        vThread2.start();
//
//        vThread1.join();
//        vThread2.join();

        final var startTime = LocalDateTime.now();
        final var vThreads = new ArrayList<Thread>();
        int vThreadCount = 100_000;

        for (int i = 0; i < vThreadCount; i++) {
            int vThreadIndex = i;
            var vThread = Thread.ofVirtual().start(() -> {
                AtomicInteger result = new AtomicInteger(1);
                IntStream.range(0, 9)
                        .forEach(val -> result.updateAndGet(v -> v * (val + 1)));
                System.out.println("Result[" + vThreadIndex + "]: " + result);
            });
            vThreads.add(vThread);
        }

        for (int i = 0; i < vThreads.size(); i++) {
            vThreads.get(i).join();
        }

//        for (int i =0; i < vThreadCount; i++) {
//            AtomicInteger result = new AtomicInteger(1);
//            IntStream.range(0, 9)
//                    .forEach(val -> result.updateAndGet(v -> v * (val + 1)));
////            System.out.println("Result[" + i + "]: " + result);
//        }
        final var endTime = LocalDateTime.now();
        System.out.println("Total duration was: " + Duration.between(startTime, endTime));
    }
}
