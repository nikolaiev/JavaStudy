package com.core.lection14.prod_consumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vlad on 01.03.17.
 * producer - consumer pattern
 *
 * All object in java have filed "lock"
 */

class Produser extends Thread{
    private final String name;
    private Queue<Object> queue;


    public Produser(Queue<Object> queue,String name) {
        this.queue = queue;
        this.name=name;
    }


    @Override
    public void run(){
        while(true){
            /*WE CAN ONLY OBTAIN OBJECT LOCK!!! NEVER METHOD'S*/
            /*only object allowed!*/
            //if queue.lock=false;
            synchronized (queue){//queue.lock=true;
                while(queue.size() >=5){
                    try {
                        /*SHOULD ALWAYS BE DECLARED IN WHILE NEVER IN IF!!!*/
                        queue.wait();//CAN ONLY BE CALLED in syncronized block
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                queue.add(new Object());
                System.out.println("Producer "+this.name+" putted item in queue");
                queue.notify();//CAN BE ONLY CALLED IN SYNCHRONIZED BLOCK
            }
        }
    }
}

class Consumer extends Thread{
    private final String name;
    private Queue<Object> queue;


    public Consumer(Queue<Object> queue, String name) {
        this.queue = queue;
        this.name=name;
    }


    @Override
    public void run(){
        while(true){
            /*WE CAN ONLY OBTAIN OBJECT LOCK!!! NEVER METHOD'S*/
            /*only object allowed!*/
            //if queue.lock=false;
            synchronized (queue){//queue.lock=true;
                while(queue.size() ==0){
                    try {
                        /*SHOULD ALWAYS BE DECLARED IN WHILE NEVER IN IF!!!*/
                        queue.wait();//CAN ONLY BE CALLED in syncronized block
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                queue.poll();
                System.out.println("Consumer "+this.name+" got item in queue");
                queue.notify();//CAN BE ONLY CALLED IN SYNCHRONIZED BLOCK
            }
            Thread.yield();//recommendation
        }
    }
}

public class  Main{
    public static void main(String[] args) throws InterruptedException {
        Queue<Object> queue=new LinkedList<>();

        Produser p1=new Produser(queue,"p1");
        Produser p2=new Produser(queue,"p2");

        Consumer c1=new Consumer(queue,"c1");
        Consumer c2=new Consumer(queue,"c2");
        Consumer c3=new Consumer(queue,"c3");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
        p1.join();
    }
}
