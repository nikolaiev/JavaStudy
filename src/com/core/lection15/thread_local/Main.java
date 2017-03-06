package com.core.lection15.thread_local;

/**
 * Created by vlad on 03.03.17.
 */

class  MyThread extends Thread{
    ThreadLocal < Integer> threadLocal;
    int val;

    public MyThread(ThreadLocal<Integer> threadLocal,int val) {
        this.threadLocal = threadLocal;
        this.val=val;
    }

    @Override
    public void run(){
        this.threadLocal.set(val);
        System.out.println(threadLocal.get());
    }
}


public class Main {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
        MyThread t1=new MyThread(threadLocal,100);
        MyThread t2=new MyThread(threadLocal,200);
        t1.start();
        t2.start();
    }
}
