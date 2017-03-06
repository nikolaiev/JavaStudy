package com.core.lection12.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by vlad on 24.02.17.
 */

//Annotation can be in field, method class
// Annotation  at Annotation  (Meta - annotation)
/*Annotation types
* 1.Source - accessible only at compilation time //@Override
* 2.Class - accessible only at compilation time // but goes on ByteCode
* 3.Runtime - accessible at compilation time and execution type //goes in byte code
* */


//default class
@Retention(RetentionPolicy.RUNTIME)//set annotation type
@interface MyAnnotation{
    String value();
}

//@MyAnnotation("hello")
class A{
    @MyAnnotation("hello")
    public void f(){
        Class c=this.getClass();
        try {
            Method f=c.getDeclaredMethod("f");
            MyAnnotation m=f.getAnnotation(MyAnnotation.class);
            System.out.println(m.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        A pa=new A();
        pa.f();

        /*Class c=Class.forName("com.core.lection12.annotation.A");
        MyAnnotation m= (MyAnnotation) c.getAnnotation(MyAnnotation.class);
        System.out.println(m.value());*/
    }
}
