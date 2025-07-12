package synchronized_examples;

public class StaticSynchronizedExchanger {

    private static Object object = null;

    public static synchronized Object getStaticSyncObject() {
        return object;
    }

    public static synchronized void setStaticSyncObject(Object object) {
        StaticSynchronizedExchanger.object = object;
    }

    // The sync blocks are equivalent to the method signatures
    public static Object getObjectSyncBlock() {
        synchronized (StaticSynchronizedExchanger.class) {
            return object;
        }
    }

    public static void setObjectSyncBlock(Object object) {
        synchronized (StaticSynchronizedExchanger.class) {
            StaticSynchronizedExchanger.object = object;
        }
    }
}
