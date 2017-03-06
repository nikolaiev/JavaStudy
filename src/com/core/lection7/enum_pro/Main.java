package com.core.lection7.enum_pro;

/**
 * Created by vlad on 13.02.17.
 */
enum Operations{//abstract class
    PLUS{//singleton anon class , extends Operations
        //int c=100;
        public int operation(int a,int b){
            return a+b/*+c */;
        }
    },
    MINUS{
        public int operation(int a,int b){
            return a-b;
        }
    };

    public abstract int operation (int a,int b);
}
/*equivalent code*/
/*
abstract class Operations1{
    public static final Operations1 PLUS=new Plus();
    public static final Operations1 MINUS=new Minus();

    public abstract int operation (int a,int b);
}

class Plus extends Operations1{

    @Override
    public int operation(int a, int b) {
        return a+b;
    }
}

class Minus extends Operations1{

    @Override
    public int operation(int a, int b) {
        return a-b;
    }
}*/

public class Main {
    public static void main(String[] args) {
        Operations e=Operations.PLUS;
        Operations e2=Operations.PLUS;

        int res=e.operation(10,20);
        System.out.println(res);

        for(Operations o:Operations.values()){
            System.out.println(o.operation(10,20));
        }
    }
}
