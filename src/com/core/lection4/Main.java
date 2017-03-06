package com.core.lection4;

/**
 * Created by vlad on 06.02.17.
 */
interface  Im_a{

}

interface  Im_b{

}

class  Test {

}
public class Main {
    public static void main(String[] args) {
    //TODO check!)(HOHFOAIHNF
        Test test=new Test();
        Im_a a=(Im_a) test;
        ((Im_b)a).equals(a);

        //pool of INtegers
        Integer i1=1000;
        Integer i2=1000;
        //i1==i2 = false

        Integer i3=100;// -128..127
        Integer i4=100;// -128..127

        //i3==i4 = true

        //POOL EXISTS ONLY FOR INTEGER TYPES : Integer, Short, Byte, Long
        //Pool does not exist for Float and Double

    }
}
