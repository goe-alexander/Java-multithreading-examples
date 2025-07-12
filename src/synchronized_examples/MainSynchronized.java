package synchronized_examples;

public class MainSynchronized {
    public static void main(String[] args) {
        var exchanger = new SynchronizedExchanger();

        Thread th1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<1000; i++) {
                            exchanger.setSyncObject("" + i);
                        }
                    }
                }
        );

        Thread th2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<1000; i++) {
                            System.out.println(exchanger.getSyncObject());
                        }
                    }
                }
        );

        th2.start();
        th1.start();
    }
}
