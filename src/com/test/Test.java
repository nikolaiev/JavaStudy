package com.test;

import java.util.ArrayList;

/**
 * Created by vlad on 11.02.17.
 */
class Super {
    Super() {
        System.out.println("Super contructor");
    }
}

public class Test extends Super {
    Test() {
        //this(1);
        System.out.println("Main() contructor");
    }
    Test(int i) {
        System.out.println("Main(int) contructor");
    }
    public static void main(String [] args) {
        new Test();
        final int i=1;
        int b=2;

        Class c1=new ArrayList<Integer>().getClass();
        Class c2=new ArrayList<String>().getClass();


        System.out.println(c1==c2);

        switch (b){
            case i:{
                System.out.println("asd");
            }
            default:
                System.out.println("22");
        }
    }
}

