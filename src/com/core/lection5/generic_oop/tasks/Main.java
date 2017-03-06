package com.core.lection5.generic_oop.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 08.02.17.
 */
interface Container<T extends Comparable<? super T>> extends Cloneable{
    Container<T> clone();
    int size();
    T get(int i);
    boolean contains(T element);
    void add (T element);
}

class MyArray<T extends Comparable<? super T>> implements Container<T>{
    List<T> elements=new ArrayList<>();

    @Override
    public Container<T> clone() {
        Container<T> copy = new MyArray<>();
        for(T element:elements){
            copy.add(element);
        }
        return copy;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public T get(int i) {
        return elements.get(i);
    }

    @Override
    public boolean contains(T element) {
        for(T elem : elements){
            if(elem.compareTo(element)==0) return true;
        }
        return false;
    }

    @Override
    public void add(T element) {
        elements.add(element);
    }
}

class Set<T extends Comparable<? super T>>{
    Container<T> container;

    public Set(Container<T> container){
        this.container=container;//should be clone!
    }

    public Set<T> union(Set<? extends T> other){
        Set<T> result = new Set<T>(this.container.clone());
        for(int i=0;i<other.container.size();i++){
            T element=other.container.get(i);
            if(!result.container.contains(element)){
                result.container.add(element);
            }
        }
        return result;
    }
}

class Table implements Comparable<Table>{
    int height;

    public Table(int h){
        this.height=h;
    }

    @Override
    public int compareTo(Table o) {
        return this.height-o.height;
    }
}

class Chair implements Comparable<Chair>{
    int width;

    public Chair(int weight) {
        this.width = weight;
    }

    @Override
    public int compareTo(Chair o) {
        return this.width -o.width;
    }
}

//cannot implemetn comparable
class ArmChair extends Chair{/*implements comparable Chair*/

    public ArmChair(int width) {
        super(width);
    }
}



public class Main {
    public static void main(String[] args) {
        Container<Table> containerTable=new MyArray<>();
        Table t1=new Table(2);
        Table t2=new Table(4);
        containerTable.add(t1);
        containerTable.add(t2);

        Set<Table> setTable=new Set<>(containerTable);

        Container<Chair> containerChair=new MyArray<>();
        Chair c1=new Chair(2);
        Chair c2=new Chair(4);
        containerChair.add(c1);
        containerChair.add(c2);

        Set<Chair> setChair=new Set<>(containerChair);



        Container<ArmChair> containerArmChair=new MyArray<>();
        ArmChair ac1=new ArmChair(2);
        ArmChair ac2=new ArmChair(4);
        containerArmChair.add(ac1);
        containerArmChair.add(ac2);

        Set<ArmChair> setArmChair=new Set<>(containerArmChair);

        //setTable.union(setChair);//error

        setChair.union(setArmChair);
        //setArmChair.union(setChair);//error
    }
}
