package com.core.lection18.locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by vlad on 13.03.17.
 */

class Writer extends Thread{
    Lock writeLock;
    Queue<Integer> queue;

    public Writer(Lock lock, Queue<Integer> queue) {
        this.writeLock = lock;
        this.queue = queue;
    }

    public void run(){
        writeLock.lock();
        queue.add(ThreadLocalRandom.current().nextInt());
        writeLock.unlock();
    }
}

class Reader extends Thread{
    Lock readLock;
    Queue<Integer> queue;

    public Reader(Lock lock, Queue<Integer> queue) {
        this.readLock = lock;
        this.queue = queue;
    }

    public void run(){
        readLock.lock();
        System.out.println(queue.peek());
        readLock.unlock();
    }
}

public class MyReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLock lock=new ReentrantReadWriteLock();
        LinkedList<Integer> linkedList=new LinkedList<>();
        Writer writer=new Writer(lock.writeLock(),linkedList);
        Reader reader=new Reader(lock.readLock(),linkedList);
        Reader reader2=new Reader(lock.readLock(),linkedList);

        writer.start();
        reader.start();
        reader2.start();
    }
}
