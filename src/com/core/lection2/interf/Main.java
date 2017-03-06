package com.core.lection2.interf;

/**
 * Created by vlad on 01.02.17.
 */


//функциональный интерфейс
interface intB{
    int a=20;

    void g();
}
interface intA{
    int a=10; //public static final;

    public abstract void g();

    default void g2(){
        System.out.println("G");
    }

    static void p(){

    }

}

class  B implements intA, intB{

    @Override
    public void g() {

    }

    @Override
    public void g2() {

    }
}

class  C {
    public void g2(){

    }
}


class D extends C implements intA{

    @Override
    public void g() {

    }
}
//функициональный интрефейс - инт. который имеет ЕДИНЫЙ абстрю метод (статических и дефолтных метдов может быть много)

public class Main {
    public static void main(String[] args) {

    }
}
