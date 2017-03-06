package com.core.lection16.concurrency.queues;

/**
 * Created by vlad on 06.03.17.
 */

class  Producer extends Thread{
    MyConcurrentLinkedQueue queue;

    public Producer(MyConcurrentLinkedQueue queue) {
        this.queue = queue;
    }

    public void run(){
        for(int i=0;i<200_000;i++){
            queue.add(i);
        }
    }
}

class  Consumer extends Thread{
    MyConcurrentLinkedQueue queue;

    public Consumer(MyConcurrentLinkedQueue queue) {
        this.queue = queue;
    }


    public void run(){
        for(int i=0;i<100_000;i++){
            if(queue.remove()==null)
                i--;
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyConcurrentLinkedQueue queue=new MyConcurrentLinkedQueue();
        Producer producer=new Producer(queue);
        Producer producer2=new Producer(queue);

        Consumer consumer1=new Consumer(queue);
        Consumer consumer2=new Consumer(queue);

        producer.start();
        producer2.start();

        consumer1.start();
        consumer2.start();

        producer.join();
        producer2.join();

        consumer1.join();
        consumer2.join();

        System.out.println(queue.size);
    }
}
