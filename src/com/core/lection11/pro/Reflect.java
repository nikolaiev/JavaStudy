package com.core.lection11.pro;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vlad on 24.02.17.
 */

class A{
    int a;

    public A(int a) {
        this.a = a;
    }

    public A() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c1=Class.forName("com.core.lection11.com.pro.A");
        A pa=(A)c1.newInstance();
        System.out.println(pa);

        Constructor constructor=c1.getDeclaredConstructor(int.class);
        A pa2=(A)constructor.newInstance(new Integer(10));
    }
}
