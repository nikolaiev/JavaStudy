package com.core.lection4.clone_method.incaps_error;

/**
 * Created by vlad on 06.02.17.
 */

//only clone method is overrided in  Array
//types of Cloning поверхностное и глубокое

class A{
    private B pB;

    public A(B pB){
        this.pB=pB;
    }

    //нарушение инкапсуляции
    public B getpB() {
        return pB;
    }

    //нарушение инкапсуляции
    public void setpB(B pB) {
        //objects does not clone itself -- it's ERROR
        this.pB = pB;
    }
}

class B{
    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    int b;
}
public class Main {
    public static void main(String[] args) {

    }
}
