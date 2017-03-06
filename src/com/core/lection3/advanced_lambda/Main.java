package com.core.lection3.advanced_lambda;

/**
 * Created by vlad on 03.02.17.
 */
interface A{
    void f();
}
public class Main {
    public static void main(String[] args) {
        int c=10;
        A pa=()->{
            //c++; //should be finale
            System.out.println("A "+(c+1));
        };
    }
}
//pattern MONADA
