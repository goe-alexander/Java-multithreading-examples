package synchronized_examples;

public class MainSharedMonitorObject {
    public static void main(String[] args) {
        var monitor1 = new Object();

        var sharedMonitor1 = new SharedMonitorObject(monitor1);
        var sharedMonitor2 = new SharedMonitorObject(monitor1);

        sharedMonitor1.incCounter();
        sharedMonitor2.incCounter();


        // because this is a new monitor object it will not block with sharedMonitor 1 and 2
        var monitor2 = new Object();
        var sharedMonitor3 = new SharedMonitorObject(monitor2);

        sharedMonitor3.incCounter();
    }
}
