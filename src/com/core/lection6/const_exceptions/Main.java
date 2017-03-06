package com.core.lection6.const_exceptions;

/**
 * Created by vlad on 10.02.17.
 */


//УТЕЧКА ПАМЯТИ
class A{
    public static A instance;
    int b;
    int c;

    public A(int a) throws Exception {
        instance=this;
        b=10;
        if(a==0){
            throw new Exception();
        }
        c=3;//будет 0 а не 3!!!!
    }
}
public class Main {
    public static void main(String[] args) {
        A pa=null;
        try {
            pa=new A(0);
        }
        catch (Exception e){

        }
        System.out.println(pa);
        System.out.println(A.instance.c);
    }
}
