package com.core.lection18.collections;

/**
 * Created by vlad on 13.03.17.
 */

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


class MyProducer extends Thread{
    List<Integer> queue=new CopyOnWriteArrayList<>();
    @Override
    public void run(){

    }
}
public class MyCopyOnWriteArrayList {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
