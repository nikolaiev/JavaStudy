package com.core.patterns.behavior_patterns.memento;

/**
 * Created by vlad on 17.02.17.
 */
class A {
    int a;
    int b;

    int c;

    int d;

    public A(int a, int b) {
        this.b = b;
        this.c = c;
        this.a = a+b;
        this.d = a-b;
    }

    public Memento saveState(){
        Memento m = new Memento(this.a,this.b);
        return m;
    }

    public void restoreState(Memento m){
        this.a=m.getA();
        this.b=m.getB();
        this.c=a+b;
        this.b=a-b;
    }
}

class Memento{
    int a;
    int b;

    public Memento(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

public class Main {
    public static void main(String[] args) {
        A pa=new A(10,20);
        Memento memento=pa.saveState();
        pa=null;
        A pa1=new A(0,0);
        pa1.restoreState(memento);
    }

}
