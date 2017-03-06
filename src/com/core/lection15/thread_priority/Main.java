package com.core.lection15.thread_priority;

/**
 * Created by vlad on 03.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Thread t=new Thread();
        t.setPriority(4);
        t.getPriority();
    }
}
