package com.core.lection13.runnable_exmpl;

/**
 * Created by vlad on 27.02.17.
 */

class Sum implements Runnable{
    /*
    * volatile - для переменных отключает оптимизацию
    * (не есть синхронизацией)
    * */
    //public volatile boolean isFinished=false;
    private int begin;
    private int end;
    public long result;

    public Sum(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run(){
        for(int i=begin;i<=end;i++){
            result+=i;
        }
        //isFinished=true;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sum s1=new Sum(1,50000);
        Sum s2=new Sum(50001,100000);

        Thread t1=new Thread(s1);
        Thread t2=new Thread(s2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        /**
         * при оптимизации Дджава машины  s1.isFinished может замениться на false
         */
        //while (!s1.isFinished || !s2.isFinished ){}
        long total=s1.result+s2.result;
        System.out.println(total);
    }

}
