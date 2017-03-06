package com.core.lection11.map;

/**
 * Created by vlad on 22.02.17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Map key sould be immutable
 */

class A{
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a1 = (A) o;

        return a == a1.a;
    }

    @Override
    public int hashCode() {
        return a;
    }
}
public class MyMap {
    public static void main(String[] args) {
        Map<A,Integer> map=new HashMap<>();
        A pa=new A();
        pa.setA(10);

        map.put(pa,100);
        System.out.println(map.get(pa));

        pa.setA(25);
        System.out.println(map.get(pa));

    }
}
