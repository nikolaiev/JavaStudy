package com.core.lection19.fork_join_framework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vlad on 15.03.17.
 */

class Dihotomia extends RecursiveTask<Double> {
    double a;
    double b;
    double eps;

    public Dihotomia(double a, double b, double eps) {
        this.a = a;
        this.b = b;
        this.eps = eps;
    }


    public static double f(double x){
        return x-3;
    }

    @Override
    protected Double compute() {
        if(Math.abs(a-b)<eps){
            return a;
        }

        double c =(a+b)/2;
        if(f(a)*f(c)<=0){
            Dihotomia dihotomia=new Dihotomia(a,c,eps);
            dihotomia.fork();
            return dihotomia.join();
        }
        else{
            Dihotomia dihotomia=new Dihotomia(c,b,eps);
            dihotomia.fork();
            return dihotomia.join();
        }
    }
}

public class DihotomiaForkJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Dihotomia dihotomia=new Dihotomia(-5,5,0.001);
        ForkJoinPool pool=new ForkJoinPool();
        Future <Double>future=pool.submit(dihotomia);

        System.out.println(future.get());
        pool.shutdown();
    }
}
