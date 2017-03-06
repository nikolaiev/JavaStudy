package com.core.lection5.generics;

/**
 * Created by vlad on 08.02.17.
 */

/**
 * Class -TEMPLATE
 * @param <T>
 */
class A<T,U>{
    T a;            //Object a
    U b;//optinal type in class declaration

    public T getA() {   //public Object getA()
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}

class B{//not generic class
    Integer a=1;
    public <T> B(T a){//generic constructor
        this.a=(Integer)a;
    }
    public Integer getA(){
        return a;
    }

    public <T>  void setA(T a){//but generic method
        this.a=(Integer) a;
    }
}
public class Main {
    public static void main(String[] args) {
        //during compiling generics template T become Object type
        A<Integer,Integer> pa =new A<>();//NOT A()!!!
        //A<Double> pa1=new A<>();//NOT A()!!!
        pa.setA(100);//setA((Integer)100)
        int res=pa.getA();//(Integer)pa.getA();

        /*
        * Because of replacing T with Object and type cast? we cannot use primitive types
        * */
        Integer a=(Integer)new Object();
        System.out.println("a"+a);
        B pb2 = new <Integer>B(2);
        B pb = new B(2.3);//compile error
        pb.<Integer>setA(200);
        pb.setA(3.2);//compile time error!!!!!
    }
}
