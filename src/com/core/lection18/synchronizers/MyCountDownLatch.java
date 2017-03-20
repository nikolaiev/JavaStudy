package com.core.lection18.synchronizers;

import java.util.concurrent.CountDownLatch;

/**
 * Created by vlad on 13.03.17.
 */

class Student extends Thread{
    CountDownLatch latch;

    public Student(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run(){
        System.out.println("Student is waiting for food!");
        try {
            latch.await();
            System.out.println("Student is eating!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Chief extends Thread{
    CountDownLatch latch;

    public Chief(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run(){
        System.out.println("The chief is cooking");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The chief has cooked");
        latch.countDown();
    }
}




public class MyCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(2);
        Chief chief=new Chief(latch);
        Chief chief2=new Chief(latch);
        Student student=new Student(latch);

        student.start();
        chief.start();
        chief2.start();
    }
}
