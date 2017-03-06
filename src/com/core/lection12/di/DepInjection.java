package com.core.lection12.di;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by vlad on 24.02.17.
 */

interface MyInterface{
    void f();
}

class A {
    MyInterface myInterface;

    public void g(){
        myInterface.f();
    }
}

class B implements MyInterface{
    public void f(){
        System.out.println("B");
    }
}

class C implements MyInterface{
    public void f(){
        System.out.println("C");
    }
}
class Factory{
    public static A getInstance(String fileName) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        BufferedReader reader=new BufferedReader(new FileReader(new File(fileName)));
        String [] elements=reader.readLine().split(":");
        reader.close();
        Class ca=Class.forName("com.core.lection12.di."+elements[0]);
        A pa=(A) ca.newInstance();
        Field f=ca.getDeclaredField(elements[1]);
        f.setAccessible(true);
        Class c=Class.forName("com.core.lection12.di."+elements[2]);
        Object o =c.newInstance();

        f.set(pa,o);
        return pa;
    }
}

public class DepInjection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, IOException {
        A pa=Factory.getInstance("conf.txt");
        pa.g();
    }
}
