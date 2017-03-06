package com.core.lection15.thread_states;

/**
 * Created by vlad on 03.03.17.
 */

class  MyThread extends Thread{
    @Override
    public void run(){
        try {
            //sleep(10);
            //sleep(10000);
            synchronized (this){
                //this.wait();
                System.out.println("sut");
            }
        } catch (Exception/*InterruptedException*/ e) {
            e.printStackTrace();
        }
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread();

        synchronized (t){
            t.start();
            Thread.sleep(1000);
            System.out.println(t.getState()== Thread.State.BLOCKED);
        }

        //Thread.sleep(1000);

        //System.out.println(t.getState());//NEW  thread is created but not started!
        //t.start();
        //System.out.println(t.getState());//RUNNABLE - thread is running
        // t.interrupt();
        //Thread.sleep(10);// TIMED_WAITING - thread is sleeping //WAITING thread is wait NOT SLEEP
        //System.out.println(t.getState());//TERMINATED - thread is dead! (cant be rerunned)
        /*
        Thread.sleep(1000);
        System.out.println(t.getState());//TERMINATED - thread is dead! (cant be rerunned)

        */

    }
}
