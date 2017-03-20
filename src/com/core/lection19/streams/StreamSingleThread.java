package com.core.lection19.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vlad on 15.03.17.
 */
public class StreamSingleThread {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};

        /*get Stream<Integer> object*/
        //Stream<Integer> stream=list.stream();

        /*вычесления носят ленивый характер!
        * если не был вызван терминальный оператор, то стримы выполняться не будут
        * */
        //map не выполнится ни разу!!
        list.stream()
                .map((x)->x*2);

        Integer res=list.stream()
                .map((x)->x*2)
                .reduce(0,(x1,x2)->x1+x2);

        List<Integer> resList=list.stream()
                .map((x)->x*2)
                .collect(Collectors.toList());


        System.out.println(res);
    }
}
