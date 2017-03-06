package com.core.lection3.inner_classes.interface_static_class;

/**
 * Created by vlad on 03.02.17.
 */

//DO NOT DO THIS!!!
interface A{
    /*public static*/
    class B{
        int x=10;
    }
    /*public final static*/
    B pb=new B();
}
public class Main {
    public static void main(String[] args) {
        A.pb.x=300;
    }
}
