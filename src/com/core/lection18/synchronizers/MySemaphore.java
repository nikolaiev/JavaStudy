package com.core.lection18.synchronizers;

/**
 * Created by vlad on 13.03.17.
 */
public class MySemaphore {
    int count;

    public MySemaphore(int count){
        this.count=count;
    }

    public void acquire() throws InterruptedException {
        synchronized (this){
            while (count==0){
                wait();
            }
            count--;
        }
    }

    public void release(){
        synchronized (this){
            count++;
            this.notifyAll();
        }
    }
    public static void main(String[] args) {

    }
}
