package com.core.lection12.ins_of;

/**
 * Created by vlad on 24.02.17.
 */

class A{

}

class B{

}

class C extends B{

}
public class InstOf {
    public static void main(String[] args) {
        A pa=new A();

        //compilation error
        /*B pb=(B)pa;
        System.out.println(pa instanceof B);*/

        C pc=new C();
        System.out.println(pc instanceof B);//true

        B pb=(B)pc;
        System.out.println(pc instanceof B);//true

        B pb2=new B();
        System.out.println(pb2 instanceof C);
        C pc2 = (C)pb;
    }
}
