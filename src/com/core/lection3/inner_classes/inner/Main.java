package com.core.lection3.inner_classes.inner;

/**
 * Created by vlad on 03.02.17.
 */

//non static inner class ARE NOT PREFERABLE!
class A{
    private int a=10;
    private static int aa=20;

    class B{
        private int b=22;
        //error
        //static int bb=1;
        public void fB(){
            //has 2 "this" objects
            //in memory 2 objects!
            //firstly initialized A then B
            A.this.a=300;
            B.this.b=50;
            this.b=20;

        }
    }

    public void fA(){
        B pb=this.new B();
        pb.fB();
    }
}

//no class A instance! - error
//class C extends A.B{}

class C extends A.B{
    public C(A pa){
        pa.super();//calls constructor A
    }
}

class D extends A.B{
    static A pa=new A();

    public D(){
        pa.super();
    }
}

public class Main {
    public static void main(String[] args) {
        //A.B b=new A.B();//error

        A pa=new A();
        A.B pb =pa.new B();
        pb.fB();

        C cp=new C(pa);
        cp.fB();
    }
}
