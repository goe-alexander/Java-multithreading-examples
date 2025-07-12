package synchronized_examples;

public class MainSyncCounter {
    // Synchronized blocks also come with a happens before guarantee.
    //because the cpu or the JVM are allowed to reorder the commands if they determine that parallel execution
    //of some commands will make the code work faster.
    //However the CPU can only make this decision from a single threaded perspective
    //There are some restrictions about what reordering are allowed around sync blocks

//          Reordering constraints:
//
//    The compiler and CPU are not allowed to move:
//
//    Any memory write that happens before a monitor exit to after that exit.
//
//    Any memory read that happens after a monitor enter to before that enter.
//
//            Equivalently:
//
//    No reads or writes from outside the synchronized may be hoisted into it.
//
//    No reads or writes from inside the synchronized may be sunk out of it.

    public static void main(String[] args) {
        var counter = new SyncCounter();

        var th1 = new Thread(() -> {
           for (int i=0; i<1_000_000; i++) {
               counter.incCount();
           }
            System.out.println(counter.getCount());
        });

        var th2 = new Thread(() -> {
           for (int i=0; i<1_000_000; i++) {
               counter.incCount();
           }
            System.out.println(counter.getCount());
        });

        th1.start();
        th2.start();
    }
}
