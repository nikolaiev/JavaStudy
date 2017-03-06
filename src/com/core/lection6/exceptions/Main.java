package com.core.lection6.exceptions;

/**
 * Created by vlad on 10.02.17.
 */

/*most of Error objects created with JVM start - then thrown if necessary*/

/*checked and unchecked exceptions*/
/*try catch is obligated only for unchecked*/
class MyException extends Exception {
    int i;

    public MyException(int i) {
        this.i = i;
    }

    public int getI(){
        return this.i;
    }

    public MyException() {
    }
}

class A {
    public void f(int a) {
        /*handling exception in place of creation*/
        try {
            if (a == 0) {
                throw new MyException();
            }
        } catch (MyException e) {

        } catch (Exception e) {

        } finally {/*не сработает если в catch System.exit(0), или убиваем поток с этим кодом*/

        }
    }

    public void f2(int a) throws MyException {
        if (a == 0) {
            throw new MyException();
        }

    }

    public void f3(int a) throws MyException1 {
        /*handling exception in place of creation*/
        try {
            if (a == 0||a==1) {
                throw new MyException(a);
            }
        } catch (MyException e) {
            throw new MyException1(e);

        }
    }
}


class MyException1 extends Exception{
    public MyException1(Exception e) {
        /*cant create stack trace if extend from Throwable.class*/
        super(e);
    }
}

public class Main {
    public static void main(String[] args) {
        A a=new A();

        try {
            a.f3(0);
        } catch (MyException1 e) {
            e.printStackTrace();
        }
    }
}
