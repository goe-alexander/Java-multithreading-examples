package synchronized_examples;

public class SynchronizedExchanger {
    protected Object object = null;

    public synchronized Object getSyncObject() {
        return object;
    }

    public synchronized void setSyncObject(Object object) {
        this.object = object;
    }

    public Object getSyncBlockObject() {
        synchronized (this) {
            return object;
        }
    }

    public void setSyncBlockObject(Object object) {
        synchronized (this) {
            this.object = object;
        }
    }
}
