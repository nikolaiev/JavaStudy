package com.core.lection5.generic_oop.extend;

/**
 * Created by vlad on 08.02.17.
 */
interface C{
    public void g();
}
class A{
    void f(){
        System.out.println("!");
    };
}

class B<T extends/*NEVER implements*/ A&C,U>{
    T a;
//class B<T_Interface implements A>{ //error!!!! only extends word enabled!!!!!
    public void g(){
        a.f();//from A
    }
}

class D extends A implements  C{
    @Override
    public void g() {

    }

    @Override
    public void f() {

    }
}

//error
//class Main <T super A>{}


public class Main {
    public static void main(String[] args) {
        B<D,C> pb= new B<>(); // if C DOES NOT IMPLEMENTS A than - ERROR
        pb.a=new D();
        pb.g();
    }
}
