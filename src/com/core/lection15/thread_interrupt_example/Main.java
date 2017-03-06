package com.core.lection15.thread_interrupt_example;

/**
 * Created by vlad on 03.03.17.
 *
 * Interruption thread example
 */

class MyThread extends Thread{
    @Override
    public void run(){
        /**
         * interrupted() - returns flag and set it to false
         *
         * isInterrupted() - just returns flag
         *
         * interrupt() - set flag to true returns void
         */

        while (!isInterrupted()){
            //System.out.println("Thread works");
            try {
                /*when exception - set flag to false!!*/
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                currentThread().interrupt();//set flag to true again
            }
        }
        System.out.println("Last string by thread ;(");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new MyThread();
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();//set Thread flag "isInterrupted" set to true
    }
}
