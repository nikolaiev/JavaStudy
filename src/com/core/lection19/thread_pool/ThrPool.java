package com.core.lection19.thread_pool;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.*;

class Sum implements Callable<Integer> {
    int begin;
    int end;

    public Sum(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = begin; i < end; i++) {
            result += i;
        }
        return result;
    }
}

public class ThrPool {
    //super is error
    static <T extends ArrayList<Object>> void stat(T a){

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //System.err.println(null instanceof  Object);
        Sum sum1 = new Sum(0, 5000);
        Sum sum2 = new Sum(5000, 7000);
        Sum sum3 = new Sum(7000, 10001);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Run of tasks
        Future<Integer> future1 = executorService.submit(sum1);
        Future<Integer> future2 = executorService.submit(sum2);
        Future<Integer> future3 = executorService.submit(sum3);

        // ASYNCHRONOUS EXECUTION
        while (!(future1.isDone() && future2.isDone() && future3.isDone())) {
            System.out.println("other task");
        }

        //Getting result ("join" analogue)
        System.out.println(future1.get() + future2.get() + future3.get());


        executorService.shutdown();

    }
}
/*
1 d +
2 c +
3 b +
4 d +
5 e - //в локальных классах нельзя статик блок
6 e +
7 a -
8 a +
9 c +
10 e
*/

