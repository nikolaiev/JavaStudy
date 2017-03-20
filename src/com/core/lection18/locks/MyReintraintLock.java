package com.core.lection18.locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vlad on 13.03.17.
 */

class  Producer extends  Thread{
    Queue <Integer> queue;
    Lock l;
    Condition condition;

    public Producer(Queue<Integer> queue, Lock l,Condition condition) {
        this.queue = queue;
        this.l = l;
        this.condition=condition;
    }

    public void run(){
        l.lock();
        while (queue.size()>5){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        condition.signal();
        l.unlock();
    }
}

class Consumer extends  Thread{
    Queue <Integer> queue;
    Lock l;
    Condition condition;

    public Consumer(Queue<Integer> queue, Lock l,Condition condition) {
        this.queue = queue;
        this.l = l;
        this.condition=condition;
    }

    public void run(){
        l.lock();
        while (queue.size()==0){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        condition.signal();
        l.unlock();
    }
}

public class MyReintraintLock {
    public static void main(String[] args) {
        Lock l=new ReentrantLock();
        Condition condition=l.newCondition();
        LinkedList<Integer> linkedList=new LinkedList<>();
        Producer producer=new Producer(linkedList,l,condition);
        Consumer consumer=new Consumer(linkedList,l,condition);
        Consumer consumer2=new Consumer(linkedList,l,condition);

        producer.start();
        consumer.start();
        consumer2.start();

    }
}
