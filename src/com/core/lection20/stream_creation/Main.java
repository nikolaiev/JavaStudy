package com.core.lection20.stream_creation;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by vlad on 17.03.17.
 * to create Stream we should write splitIterator
 */

class MyArray implements Spliterator<Integer> {
    Integer[] array;
    int firstPosition;
    int lastPosition;

    protected MyArray() {}

    public MyArray(int size) {
        this.array = new Integer[size];
        firstPosition = 0;
        lastPosition = size - 1;
    }

    public void set(int pos, Integer elem) {
        array[pos] = elem;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Integer> action) {
        if(firstPosition<=lastPosition){
            action.accept(array[firstPosition]);
            firstPosition++;
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Integer> trySplit() {
        int mid = (lastPosition-firstPosition ) / 2;

        if (mid <= 1)
            return null;


        MyArray newArray=new MyArray();
        newArray.array=this.array;
        newArray.firstPosition=firstPosition+mid+1;
        newArray.lastPosition=lastPosition;

        lastPosition=firstPosition+mid;

        return newArray;
    }

    @Override
    public long estimateSize() {
        return lastPosition-firstPosition;
    }

    @Override
    public int characteristics() {
        return Spliterator.SIZED | Spliterator.SUBSIZED;
    }

    public Stream<Integer> stream(){
        firstPosition=0;
        lastPosition=array.length-1;
        return StreamSupport.stream(this,false);
    }

    public Stream<Integer> parallelStream(){
        /*firstPosition=0;
        lastPosition=array.length-1;*/
        return StreamSupport.stream(this,true);
    }
}

public class Main {
    public static void main(String[] args) {
        MyArray m=new MyArray(6);
        m.set(0,10);
        m.set(1,20);
        m.set(2,30);
        m.set(3,40);
        m.set(4,60);
        m.set(5,70);

        //m.stream().map(e->e*2).forEach(System.out::println);
        System.out.println();
        m.parallelStream().map(e->e*2).forEach(System.out::println);

    }
}
