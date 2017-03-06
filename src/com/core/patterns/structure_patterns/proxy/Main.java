package com.core.patterns.structure_patterns.proxy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlad on 15.02.17.
 *
 * proxy patter
 *
 * cache, aspects
 */

abstract class Component {
    public abstract int operation(int a,int b);
}

class Summ extends Component{

    @Override
    public int operation(int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a+b;
    }
}

class ProxySumm extends Component{
    Component c= new Summ();
    Map<Pair<Integer,Integer>,Integer> cache= new HashMap<>();

    public int operation(int a,int b){
        Integer result=cache.get(new Pair<>(a,b));
        if(result==null){
            result=c.operation(a,b);
            cache.put(new Pair<>(a,b),result);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Component c= new ProxySumm();
        c.operation(10,20);
        System.out.println("here");
        c.operation(10,20);
        System.out.println("here2");
    }
}
