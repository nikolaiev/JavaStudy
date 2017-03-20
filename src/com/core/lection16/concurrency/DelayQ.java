package com.core.lection16.concurrency;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by vlad on 10.03.17.
 */

class  MyClass implements Delayed{
    int value;
    long delayTime;

    public MyClass(int value,long delayTime) {
        this.value=value;
        this.delayTime = delayTime+System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {

        return unit.convert(delayTime-System.currentTimeMillis(),unit);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.delayTime,((MyClass)o).delayTime);
    }
}
public class DelayQ {
    public static void main(String[] args) throws InterruptedException {
        MyClass queue1=new MyClass(100,1000);
        MyClass queue2=new MyClass(200,1500);
        MyClass queue3=new MyClass(300,2000);

        Queue<MyClass> queue=new DelayQueue<>();
        queue.offer(queue1);
        queue.offer(queue2);
        queue.offer(queue3);
        while (true) {
            Thread.sleep(500);
            MyClass a=queue.poll();
            System.out.println(a==null?null:a.value);

        }

    }
}
