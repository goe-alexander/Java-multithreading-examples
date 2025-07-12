package runnable_examples;

public class CountDownTimer implements Runnable{
    private int startFrom;

    public CountDownTimer(int startFrom) {
        this.startFrom = startFrom;
    }

    @Override
    public void run() {
        try {
            while (startFrom > 0) {
                System.out.println("[" + Thread.currentThread().getName() + "] " + "Countdown: " + startFrom);
                startFrom--;
                Thread.sleep(1000);
            }
            System.out.println("Countdown finished!");
        } catch (InterruptedException e) {
            System.out.println("Countdown was interrupted");
        }
    }
}
