package com.core.lection19.fork_join_framework;

/**
 * Created by vlad on 15.03.17.
 */

class Dihotom extends Thread{
    /*a always < b*/
    double a;
    double b;
    double eps;
    double result;

    public Dihotom(double a, double b, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
    }

    public static double f(double x){
        return x-3;
    }

    @Override
    public void run(){
        if(Math.abs(a-b)>eps){
            double c = (a+b)/2;

            if(f(a)*f(c)<=0){
                Dihotom dihotom=new Dihotom(a,c,eps);
                dihotom.start();
                try {
                    dihotom.join();
                    result=dihotom.result;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                Dihotom dihotom=new Dihotom(c,b,eps);
                dihotom.start();
                try {
                    dihotom.join();
                    result=dihotom.result;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//if
        }//else
        else
        {
            result=a;
        }

    }
}

public class DihotomiaSimpleThreads {
    public static void main(String[] args) throws InterruptedException {
        Dihotom dihotom=new Dihotom(0,4,0.01);
        dihotom.start();
        dihotom.join();
        System.out.println(dihotom.result);
    }
}
