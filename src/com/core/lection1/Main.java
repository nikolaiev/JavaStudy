package com.core.lection1;
class A{
    static int a=B.fb();

    public static int fa(){
        return a+1;
    }
}

class B{
    static int b=A.fa();

    public static int fb(){
        return b+1;
    }
}


class C {
    int a=10;

    {
        a=50;
    }

    //initializer
    public C(int b){
        this.a=b;
    }
    //mthod
    public void C(int b){

    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(-2>>1);
        /*побитовый операции
         *инверия
         */
        byte a=1;
        byte b=2;
        //Erorr
        //byte c=a+b;

        a=(byte)-Byte.MIN_VALUE;
        a=(byte)-a;//a=-128 ;)
        System.out.println(0.3==0.1+0.1+0.1);

        //float comparation
        double f1=2.3;
        double f2=2.4;
        double eps=0.1;
        System.out.println(Math.abs(f1-f2)<eps);

        //if value is NaN
        double x=0.0/0.0;
        System.out.println(x!=x);

        //суммирование от меньше к большему

        //----------------
        //char -> int unicode
        //unicade has 4 forms/
        System.out.println(Float.MAX_VALUE);
        //----------------------------------------------------------------------------

        //структура класа в куче
        System.out.println(A.a);
        System.out.println(B.b);
    }
}
