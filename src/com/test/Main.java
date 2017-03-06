package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vlad on 09.02.17.
 */
/*complicated wildcard for compilation time error */
interface Container <T extends Comparable<? super T> > extends Cloneable {
    void add(T elem);
    Container<T> clone();
    int size();
    T get(int index);
    boolean contains(T element);
}

class Set<T extends Comparable<? super T>> implements Iterable<T>{
    Container <T> container;

    public Set(Container<T> container){
        this.container=container.clone();
    }

    public Set<T> union(Set<? extends T> other){
        Set<T> result=new Set<T>(this.container);
        for(T elem : other){
            if(!container.contains(elem)){
                result.container.add(elem);
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        /*anonymus inner class*/
        return new Iterator<T>() {
            private int index=0;

            @Override
            public boolean hasNext() {
                return index<container.size();
            }

            @Override
            public T next() {
                return container.get(index++);
            }
        };
    }

}

/*custom implementation of Container Interface*/
class MyContainer <T extends Comparable<? super T>> implements Container<T>{
    ArrayList<T> list=new ArrayList<>();

    public MyContainer(){}

    @Override
    public void add(T elem) {
        list.add(elem);
    }

    @Override
    public Container<T> clone() {
        Container<T> copy=new MyContainer<T>();
        for(T elem : list){
            copy.add(elem);//TODO make clone method for deep copy!!
        }
        return copy;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public boolean contains(T element) {
        //return list.contains(element);//for equals
        for (T elem :
                list) {
            if(elem.compareTo(element)==0){
                return true;
            }
        }
        return false;
    }


}

class Table implements Comparable<Table>{
    int t;
    public Table(int t){
        this.t=t;
    }

    @Override
    public int compareTo(Table o) {
        return this.t-o.t;
    }
}

class Chair implements Comparable<Chair>{
    int c;

    public Chair(int c) {
        this.c = c;
    }

    @Override
    public int compareTo(Chair o) {
        return this.c-o.c;
    }
}

class ArmChair extends Chair{
    public ArmChair(int c) {
        super(c);
    }
}



public class Main {

    public static void main(String[] args) {
        /*Tables*/
        MyContainer<Table> tables=new MyContainer<Table>(){{
            add(new Table(1));
            add(new Table(2));
        }};
        Set<Table>  tableSet=new Set<>(tables);

        /*Chairs*/
        MyContainer<Chair> chairs=new MyContainer<Chair>(){{
            add(new Chair(1));
            add(new Chair(2));
        }};

        //chairSet.union(tableSet);//error because of types!!

        /*Chairs 2*/
        Set<Chair>  chairSet=new Set<>(chairs);

        MyContainer<Chair> chairs2=new MyContainer<Chair>(){{
            add(new Chair(1));
            add(new Chair(2));
        }};

        //test command
        Set<Chair>  chairSet2=new Set<>(chairs);

        /*ArmChair*/
        MyContainer<ArmChair> armChairs=new MyContainer<ArmChair>(){{
            add(new ArmChair(1));
            add(new ArmChair(2));
        }};
        Set<ArmChair>  armChairSet=new Set<>(armChairs);

        chairSet.union(armChairSet);


    }
}
