package com.core.lection5.generic_oop.wildcard;

import java.util.ArrayList;

/**
 * Created by vlad on 08.02.17.
 */
class A<T>{
    T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}

class D{

}
class B extends D{
}

class C extends B{
    int c;

    public C(int c){
        super();
        this.c=c;
    }
}

public class Main {
    public static void f(A<? super B> pa){
        C pc=new C(4);
        pa.setA(pc);//можем передать В и его наследников
        D pd= new D();
        //pa.setA(pd);//error
    }//супер может использоваться только со знаком вопроса

    public static void f2(A<? extends B> pa){}//внутри этого метода сеттеры вызываться не будут!
    public static void f1(ArrayList<? extends B> list){//можем читать и удалять!
        //list.set(1,new C(2));
    }

    public static void main(String[] args) {
        //wildcard
        A<D> pa=new A<>();//к знаку вопроса привести нельзя а знак вопроса можно привести ко всем типам!!!
        //pa.setA((Integer)1); //error
        //int res=(Integer)pa.getA();
        f(pa);

        ArrayList<C> list=new ArrayList<C>(){{
            add(new C(1));
            add(new C(2));
        }};

        f1(list);
        System.out.println(list);
    }
}
