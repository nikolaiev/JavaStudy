package com.core.lection15.thread_group;

/**
 * Created by vlad on 03.03.17.
 */
class  MyThread implements  Runnable{
    @Override
    public void run(){
        while (true){
            System.out.println("1");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        ThreadGroup parent= new ThreadGroup("parent");
        ThreadGroup tg=new ThreadGroup(parent,"child");
        MyThread myThread=new MyThread();
        Thread t=new Thread(tg,myThread);
        t.start();
    }
}
