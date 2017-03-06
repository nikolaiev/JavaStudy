package com.core.lection3.inner_classes.local_class;

/**
 * Created by vlad on 03.02.17.
 */
class A{
    int aa=31;
    //error
    /*static*/
    //java don't have closure (only constants)
    public C fA(){

        /*final*/ int a=10;
        /*a=100;*/
        class B implements C{
            int b=20;

            public void fB(){
                System.out.println("1 "+a);
                System.out.println(aa);
            }
        }
        B pb=new B();
        return pb;
    }
}

interface C {
    public void fB();
}

public class Main {
    public static void main(String[] args) {
        A pa=new A();
        C o=pa.fA();
        o.fB();
    }
}
