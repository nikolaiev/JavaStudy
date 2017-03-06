package com.core.lection4.clone_method.deep_nondeep_clone;

/**
 * Created by vlad on 06.02.17.
 */

//if does nor impl Cloneable and has clone method then CloneUnsupportedExeption;
class A /*implements Cloneable*/{
    private int a=1;
    int [] arr={1,2,3};

    public A(){

    }

    //copying constructor
    public A(A pa){

    }

    //nondeep (shallow) cloning
    /*@Override
    public A clone(){
        A copy = new A();
        copy.a=this.a;
        //shared our array!!!!!
        copy.arr=this.arr;
        return copy;
    }*/

    //deep cloning
    @Override
    public A clone(){
        A copy = new A();
        copy.a=this.a;
        //cloned our array!!!!!
        //if non primitives then array - new but objects inside are same!
        copy.arr=this.arr.clone();
        return copy;
    }

    //restrict cloning!
    /*@Override
    public A clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }*/
}
public class Main {
    public static void main(String[] args) {
        A a=new A();
        A pa=a.clone();
    }
}
