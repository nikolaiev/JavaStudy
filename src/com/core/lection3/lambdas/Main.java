package com.core.lection3.lambdas;

/**
 * Created by vlad on 03.02.17.
 */

//functional interface
interface A{
    void fA(int a,int b);
}

//do not implements A
class B{
    public static void fB(int a,int b){
        System.out.println(a+b);
    }

    public static void fA(int a,int b){
        System.out.println(a+b);
    }
}

class C{
    public void fC(int a , int b){
        System.out.println(a*b);
    }
}

public class Main {
    public static void main(String[] args) {
        A pa=(a,b)->{
            System.out.println(a+b);
        };
        pa.fA(1,2);
        //equivalent code
        class NoName implements A{

            @Override
            public void fA(int a,int b) {
                System.out.println("A");
            }
        }

        A pa1=new NoName();
        pa1.fA(3,4);

        //refference to function
        A pa2=B::fB;
        pa.fA(3,4);

        //equivalents

        class NoName2 implements A{
            public void fA(int a,int b){
                B.fB(a,b);
            }
        }

        A pa3=new NoName2();

        pa3.fA(2,3);

        C pc=new C();
        //non static reference
        A pa4=pc::fC;

        //equivalent code

        class NoName3 implements A{
            C pc;
            public NoName3(C pc){
                this.pc=pc;
            }
            @Override
            public void fA(int a, int b) {
                pc.fC(a,b);
            }
        }
    }
}
