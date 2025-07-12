package runnable_examples;

public class MyMemoryRunnable implements Runnable{
    private int count = 0;

    @Override
    public void run() {

        Object myObject = new Object();
        System.out.println(myObject);

        for (int i=0; i<100_000; i++) {
            synchronized (this) {
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName()+ " : " + this.count);
    }
}
