package com.core.lection14.dead_lock;

import sun.awt.windows.ThemeReader;

/**
 * Created by vlad on 01.03.17.
 */

class MyThread extends Thread{
    Object o1;
    Object o2;


    public MyThread(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run(){
        synchronized (o1){
            synchronized (o2){

            }
        }
    }
}

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Object o1=new Object();
        Object o2=new Object();

        Thread t1=new MyThread(o1,o2);
        Thread t2=new MyThread(o2,o1);
        t1.start();
        t2.start();
        t1.join();
    }
}
