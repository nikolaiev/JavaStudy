package com.core.lection7.enum_example;

/**
 * Created by vlad on 13.02.17.
 */


/*траслируется в абстрактный класс*/
enum MyEnum {
    RED(10), BLACK(20), WHITE(30);//always first line in ENUM declaration
    int a;
    static int b=100;

    /*ONLY PRIVATE CONSTRUCTOR!!!*/
    private MyEnum(int a){
        this.a=a;
    }

    public int getA(){
        return a;
    }
}


public class Main {
    //type safety!
    public static void f(MyEnum e/*String s*/) {

    }

    public static void main(String[] args) {
        MyEnum e = MyEnum.BLACK;
        System.out.println(e.ordinal());
        System.out.println(e.a);
    }
}
