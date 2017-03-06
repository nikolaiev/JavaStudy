package com.core.lection2.polym;

/**
 * Created by vlad on 01.02.17.
 */
class A {
    int a = 2;

    public A() {
        f();
        System.out.println(a);
    }

    public void f() {
        System.out.println("A");

    }

    public static void test(){
        System.out.println("A");
    }
}

class B extends A {
    int a = 4;

    public B() {
        f();

        System.out.println(a);
    }

    public void f() {
        System.out.println("B");
    }

    public static void test() {
        System.out.println("B");
    }
}

//private methods are no virtual
public /*package*/ class Main {
    public static void main(String[] args) {
        A pa = new B();//polymorphism
        //pa.f();//invoke virtual pa.f() // if f is not STATIC!!!!
        //or invoke static A ,f //is static and private or just static
        //or invoke special pa,f // if it's private
        pa.test();
    }

}
