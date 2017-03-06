package com.core.lection6.except_extend;

/**
 * Created by vlad on 10.02.17.
 */

class MyException extends Exception{

}

class MyException1 extends MyException{

}

class A{
    public void f(int a) throws MyException {
        if(a==0){
            throw new MyException();
        }
    }
}

class B extends A{
    @Override
    public void f(int a) throws MyException1  {
        throw new MyException1();
    }
}

public class Main {
    public static A  g(){
        return new B();
    }
    public static void main(String[] args) {
        A pa=g();
        try {
            pa.f(1);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
