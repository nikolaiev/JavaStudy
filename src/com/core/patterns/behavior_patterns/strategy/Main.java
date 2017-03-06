package com.core.patterns.behavior_patterns.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlad on 20.02.17.
 */


abstract class Strategy{
    public abstract void sort();
}

class InsertSort extends Strategy{
    public void sort(){
        System.out.println("InsertSort");
    }
}

class QuickSort extends Strategy{
    public void sort(){
        System.out.println("Quick Sort");
    }
}

public class Main {

    public static void f(Strategy s){
        s.sort();
    }
    public static void main(String[] args) {
        Strategy s=new InsertSort();
        f(s);
        Map<Integer,HashMap<Integer,Integer>> a=new HashMap<Integer,HashMap<Integer,Integer>>();
    }
}
