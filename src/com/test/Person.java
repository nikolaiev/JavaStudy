package com.test;

/**
 * Created by vlad on 09.02.17.
 */
class A{
    public void f(){
        System.out.println(this.getClass());
    }
}

class B extends A{}

public class Person implements Cloneable{

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
        //return new Person(this.name);
    }

    public static void main(String[] args) {
        final boolean test=new Boolean(false);
        Byte [][] Byte;//={{0}};
        char a='1';
        char b='2';
        System.out.println(a+b);
        //final var can be in foreach

        /*B b=new B();
        b.f();
        Person p = new Person("Sam");
        try {
            // Person class doesn't implement Cloneable but tries to get clone. It fails
            // with CloneNotSupportedException
            Person pClone = (Person) p.clone();
            System.out.println(pClone.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}