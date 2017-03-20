package com.core.lection18.synchronizers;

/**
 * Created by vlad on 13.03.17.
 */

class Barrier{
    int count;

    public Barrier(int count) {
        this.count = count;
    }

    public void await() throws InterruptedException {
        synchronized (this){
            count--;

            while (count != 0) {
                new Object().wait();
            }
            this.notifyAll();
        }
    }
}

public class MyCyclicBarrier {
}
