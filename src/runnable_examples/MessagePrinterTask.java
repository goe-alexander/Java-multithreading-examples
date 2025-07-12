package runnable_examples;

public class MessagePrinterTask implements Runnable{
    private boolean stopRequested = false;

    public synchronized  void requestStop() {
        this.stopRequested = true;
    }

    public synchronized boolean isStopRequested() {
        return this.stopRequested;
    }
    private final String message;
    private final int times;

    public MessagePrinterTask(String message, int times) {
        this.message = message;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i< times; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " +  message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task was interrupted");
                break;
            }
        }
    }


}
