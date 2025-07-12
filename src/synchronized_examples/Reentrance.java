package synchronized_examples;

public class Reentrance {
    // A thread that already holds the lock on the monitor object is allowed to enter
    // and it will not be blocked.
    private int count = 0;
    public synchronized  void inc() {
        this.count++;
    }

    public synchronized int incAndGet() {
        inc();
        return this.count;
    }
}
