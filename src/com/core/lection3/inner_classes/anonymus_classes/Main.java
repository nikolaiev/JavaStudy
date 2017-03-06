package com.core.lection3.inner_classes.anonymus_classes;

import java.util.ArrayList;

/**
 * Created by vlad on 03.02.17.
 */
interface C{
    void fC();
}

class A{
    public void fA(){
        C pc=new C(){
            public void fC(){
                System.out.println("C");
            }
        };

        pc.fC();
    }
}

class A1{
    public void fA(){
        class NoName implements C{

            @Override
            public void fC() {
                System.out.println("C");
            }
        }
        C pc=new NoName();
        pc.fC();
    }
}
//A1 and A - equivalent classes

class D{
    int d=10;
    C pc=new C(){

        @Override
        public void fC() {
            d=20;
        }
    };
}


public class Main {

    public static void main(String[] args) {

        //double brace
        A1 a=new A1(){
            {
                //block of non static initializing
                System.out.println("1");
            }
        };

        //equivalent code

        class NoName extends ArrayList{
            {
                super.add(10);
                add(30);
                add(20);
            }
        }

        ArrayList a1= new NoName();
    }
}
