package com.core.lection6.no_catch;

import java.io.Closeable;

/**
 * Created by vlad on 10.02.17.
 */

class A implements Closeable{
    public void f(int a) {
        if(a==0){
            throw new RuntimeException();
        }
    }

    @Override
    public void close() /*throws IOException*/ {
        System.out.println("close");
    }
}

public class Main {
    public static void main(String[] args) {

        try(A pa=new A()){
            pa.f(0);
        }


        //equ code
        A pa1 =new A();
        try{
            pa1.f(0);
        }
        finally {
            pa1.close();
        }
    }
}
