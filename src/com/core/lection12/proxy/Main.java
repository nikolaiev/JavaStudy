package com.core.lection12.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by vlad on 24.02.17.
 */

interface MyInterface{
    default int f(int a,int b){
        return a+b;
    }
}

class B implements MyInterface{

}

class MyInvokationHandler implements InvocationHandler{
    private MyInterface pa;

    public MyInvokationHandler(MyInterface pa) {
        this.pa = pa;
    }

    public MyInterface getInstance(){
        return (MyInterface) Proxy.newProxyInstance(pa.getClass().getClassLoader(),pa.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("f")){
            int a=((Integer)args[0])*2;
            int b=((int)args[1])*2;

            return method.invoke(pa,a,b);
        }
        return method.invoke(pa,args);
    }
}

public class Main {
    public static void main(String[] args) {
        MyInterface pa= new MyInvokationHandler(new B()).getInstance();
        int res=pa.f(10,20);
        System.out.println(res);


    }
}
