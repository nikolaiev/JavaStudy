package com.core.lection13.thread_exmpl;

/**
 * Created by vlad on 27.02.17.
 */

/*
* Процесс не выполняет полезных действий (захватывает оперативную память) (основная задача - захват ресурсов)
* Поток - есть исполнитель
* */

/*
 *Защищенный режим - недоступность области памяти одного процесса для других процессов!
 * (не расспостраняется на процессы ядра)
 */

/*
* Вытесняющая многозадачность
* */

/*
* Архитектуры процессора
*
* */


class Sum extends Thread{
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

/*Подсчитать сумму ряда 1,2,3....10000*/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sum s1=new Sum(1,50000);
        Sum s2=new Sum(50001,100000);

        s1.start();//method start - async
        //s1.start() - exception
        s2.start();
        s1.join();
        s2.join();

        /**
         * при оптимизации Дджава машины  s1.isFinished может замениться на false
         */
        //while (!s1.isFinished || !s2.isFinished ){}
        long total=s1.result+s2.result;
        System.out.println(total);
    }
}
