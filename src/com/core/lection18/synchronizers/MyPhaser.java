package com.core.lection18.synchronizers;

import java.util.concurrent.Phaser;

/**
 * Created by vlad on 13.03.17.
 */

class MyThreadZero extends Thread{
    Phaser phaser;

    public MyThreadZero(Phaser phaser) {
        this.phaser = phaser;
    }

    public void run(){
        phaser.register();

    }
}

class  MyThreadTwo extends Thread{
    Phaser phaser;

    public MyThreadTwo(Phaser phaser) {
        this.phaser = phaser;
    }

    public void run(){
        phaser.arriveAndAwaitAdvance();
        System.out.println("The thread is unregistered");
    }
}

class  MyThreadThree extends Thread{
    Phaser phaser;

    public MyThreadThree(Phaser phaser) {
        this.phaser = phaser;
    }

    public void run(){
        phaser.arrive();
        System.out.println("The thread is unregistered");
    }
}
public class MyPhaser {
    public static void main(String[] args) {
        Phaser phaser=new Phaser(3);

        MyThreadZero myThread=new MyThreadZero(phaser);

        MyThreadTwo threadTwo1=new MyThreadTwo(phaser);
        MyThreadTwo threadTwo2=new MyThreadTwo(phaser);
        MyThreadTwo threadTwo3=new MyThreadTwo(phaser);
        MyThreadTwo threadTwo4=new MyThreadTwo(phaser);

        MyThreadThree threadThree=new MyThreadThree(phaser);


        myThread.start();


        threadTwo1.start();
        threadTwo2.start();
        threadTwo3.start();
        //threadTwo4.start();
        threadThree.start();
    }
}
