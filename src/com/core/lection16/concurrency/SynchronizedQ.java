package com.core.lection16.concurrency;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by vlad on 10.03.17.
 */
public class SynchronizedQ {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue<>();


        new Thread(()->{

            try {
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        synchronousQueue.put(1);

    }
}
