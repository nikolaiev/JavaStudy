package com.core.lection15.thread_deamon;

/**
 * Created by vlad on 03.03.17.
 */

class  MyThread extends Thread{
    @Override
    public void run(){
        while (true){
            System.out.println("myThread");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new MyThread();
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(1000);
        t1.join();
        /*Daemon thread lives until at least 1 user thread is alive*/
    }
}
