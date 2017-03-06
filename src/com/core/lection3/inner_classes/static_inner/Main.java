package com.core.lection3.inner_classes.static_inner;

/**
 * Created by vlad on 03.02.17.
 */
class A{
    public int a=10;
    private static int aa=20;

    public void fA(){
        B.bb=50;//access to static field of static inner class
        B pb=new B();
        pb.b=100;
    }

    public void getStaticPrivateBmember(){
        System.out.println(B.bb);
    }

    static class B{
        private int b=01;
        private static int bb=20;

        public void fB(){
            aa=30;//access to private field
        }

        public void getAA(){
            System.out.println(aa);
        }
    }

}

//class C does not inherit A class' field
class C extends A.B{
    public void fC(){
        //A.aa=400;//error
    }

}
public class Main {
    public static void main(String[] args) {
        A.B p=new A.B();
        p.fB();
        p.getAA();

        A a=new A();
        a.getStaticPrivateBmember();
    }
}
