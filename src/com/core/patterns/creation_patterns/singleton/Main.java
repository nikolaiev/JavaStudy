package com.core.patterns.creation_patterns.singleton;

/**
 * Created by vlad on 15.02.17.
 */
class Singleton{
    private static Singleton instance=new Singleton();
    private Singleton(){

    }

    public static Singleton getInstance(){
        //не подходит для многопоточности
        /*if(instance==null)
            instance=new Singleton();*/
        return instance;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
