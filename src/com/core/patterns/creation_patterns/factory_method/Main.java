package com.core.patterns.creation_patterns.factory_method;

/**
 * Created by vlad on 15.02.17.
 * FACTORY METHOD PATTERN
 */

class B{

}
class A{
    int a;

    private A(int a){
        this.a=a;
    }

    public static A getInstance(int a){
        if(a==0)
            throw new IllegalArgumentException();
        return new A(a);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

public class Main {
    public static void main(String[] args) {
        A pa=A.getInstance(10);
    }
}
