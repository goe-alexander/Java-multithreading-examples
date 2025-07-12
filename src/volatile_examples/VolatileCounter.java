package volatile_examples;

public class VolatileCounter {
    private volatile int count = 0;

    // This is a clear case where the volatile count property is not enough
    // The entire block should have been synchronized.
    public boolean inc() {
        if(this.count == 10) {
            return false;
        }
        this.count++;
        // THe increment is not atomic
        // first there is a read
        // increment of the variable
        //write of the variable
        return true;
    }
}
