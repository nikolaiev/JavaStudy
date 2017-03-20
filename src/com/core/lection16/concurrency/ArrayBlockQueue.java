package com.core.lection16.concurrency;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by vlad on 10.03.17.
 */
public class ArrayBlockQueue {
    public static void main(String[] args) {
        Queue<Integer> queue=new ArrayBlockingQueue<Integer>(2);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
