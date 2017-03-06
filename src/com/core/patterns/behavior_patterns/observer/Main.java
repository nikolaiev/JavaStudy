package com.core.patterns.behavior_patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 17.02.17.
 */
interface Obsorver{
    void notify(int oldVal, int newVal);
}
class MyObsorver implements  Obsorver{
    public void notify(int oldVal, int newVal){
        System.out.println("ALAH AKBAR "+oldVal+" "+newVal);
    }
}
class Obsorvable{
    int value;//obsorvable
    List<Obsorver> obsorvers=new ArrayList<>();

    public void addObsorvet(Obsorver o){
        obsorvers.add(o);
    }

    public void removeObsorver(Obsorver o){
        obsorvers.remove(o);
    }

    public void setValue(int newValue){
        for(Obsorver o:obsorvers){
            o.notify(value,newValue);
        }
        this.value=value;
    }
}
public class Main {
    public static void main(String[] args) {
        Obsorvable  obsorvable=new Obsorvable();

        Obsorver m1=new MyObsorver();
        Obsorver m2=new MyObsorver();

        obsorvable.addObsorvet(m1);
        obsorvable.addObsorvet(m2);

        obsorvable.setValue(2);
    }
}
