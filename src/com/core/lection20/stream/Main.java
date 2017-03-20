package com.core.lection20.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by vlad on 17.03.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //Stream<Integer> stream =list.stream().map(e->e*2);
        //stream.reduce(0,(a,b)->a+b);
        //stream.reduce(1,(a,b)->a*b); //error cant call one more time

        list.parallelStream().map(e->e*2).forEach(System.out::println);
    }
}
