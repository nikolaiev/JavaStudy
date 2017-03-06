package com.core.lection2.ext;

/**
 * Created by vlad on 01.02.17.
 */
class A{
    int a;
    public void f(){
        int a=30;
        System.out.println(this.a);
    }
}

class B extends A{
    int a;
    public int g(){
        System.out.println(super.equals(this));//true
        return a + super.a;
    }
}
public class Main {
    public static void main(String[] args) {
        A a =new A();
        a.f();
    }
}
