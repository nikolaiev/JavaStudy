package com.core.patterns.behavior_patterns.mediator;

/**
 * Created by vlad on 17.02.17.
 */

abstract class Test{
    public void setM(Mediator m) {
        this.m = m;
    }

    Mediator m;


    public void sendMessage(String message,Class c){
        m.send(message,c);
    }

    public void receiveMessage(String message){
        System.out.println(message);
    }
}

class A extends Test{
}

class B extends Test{
}

class C extends Test{
}

class Mediator{
    A pa;
    B pb;

    C pc;

    public void setPa(A pa) {
        this.pa = pa;
    }

    public void setPb(B pb) {
        this.pb = pb;
    }

    public void setPc(C pc) {
        this.pc = pc;
    }



    public void send(String message,Class c){
        System.out.println(c.getName());
        switch (c.getName()){
            case "A":pa.receiveMessage(message); break;
            case "B":pb.receiveMessage(message); break;
            case "C":pc.receiveMessage(message); break;
        }
    }
}
public class Main {
    public static  void main(String ... args){
        Mediator m = new Mediator();
        A pa =new A();
        B pb =new B();
        C pc =new C();

        m.setPa(pa);
        m.setPb(pb);
        m.setPc(pc);

        pa.setM(m);
        pb.setM(m);
        pc.setM(m);

        pa.sendMessage("Test",B.class);
    }
}
