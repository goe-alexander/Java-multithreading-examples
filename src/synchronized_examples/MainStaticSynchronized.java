package synchronized_examples;

public class MainStaticSynchronized {
    public static void main(String[] args) {

        Thread th1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<1000; i++) {
                            StaticSynchronizedExchanger.setStaticSyncObject("" + i);
                        }
                    }
                }
        );

        Thread th2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<1000; i++) {
                            System.out.println(StaticSynchronizedExchanger.getStaticSyncObject());
                        }
                    }
                }
        );

        th2.start();
        th1.start();
    }
}
