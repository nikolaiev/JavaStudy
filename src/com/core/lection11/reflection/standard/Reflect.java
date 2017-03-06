package com.core.lection11.reflection.standard;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by vlad on 22.02.17.
 */

class A{
    private int value;


    public A() {
    }

    public A(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("A");

        /*Class c2 = A.class;
        A pa=new A();
        Class c3= pa.getClass();*/

        Field field=c1.getDeclaredField("value");
        System.out.println(field.getType());

        System.out.println(Modifier.toString(field.getModifiers()));

        A pa=new A();

        field.setAccessible(true);

        field.set(pa,111);

        System.out.println(pa.getValue());

        Field [] fields=c1.getDeclaredFields();
        System.out.println(Arrays.deepToString(fields));


        /*Methods*/

        Method method=c1.getDeclaredMethod("setValue",int.class);
        System.out.println(method.getReturnType());

        method.invoke(pa,100);

        System.out.println(pa.getValue());

    }
}
