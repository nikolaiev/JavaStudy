package com.core.lection15.thread_and_exception;

import java.util.Queue;

/**
 * Created by vlad on 03.03.17.
 */

/*custom exception handler*/
class MyHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}


class  MyThread extends Thread{
    @Override
    public void run(){
        if(true){
            throw  new RuntimeException("MyThread throw exception");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //register exception handler!
        Thread.setDefaultUncaughtExceptionHandler(new MyHandler());
        Thread t=new MyThread();
        //t.setDaemon(true);
        t.start();
        //Thread.sleep(1000);
    }
}
