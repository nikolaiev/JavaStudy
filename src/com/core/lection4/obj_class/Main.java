package com.core.lection4.obj_class;

/**
 * Created by vlad on 06.02.17.
 */

/* Objects public methods

    equals
    hashCode
    getClass
    finalize

    notify
    notifyAll
    wait
    wait(time)
    wait(time,nanosecs)  //for future processors

    toString
    clone
*/
class A{
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(Object obj){
        if (obj==null){
            return false;
        }

        //bad practice
        if(! (obj instanceof A)){
            return false;
        }

        return this.value==((A) obj).value;
    }

    public int hashCode(){
        //return 0; - formally OK
        return value;
    }

    @Override
    public String toString(){
        return ""+value;
    }

}
public class Main {
    public static void main(String[] args) {
        //equals in Object equ to "=="
        //если переопределяем equals than we should override hashCode!!
        //if equals =true then hashcode = true
        //if hashCode =true then NOT ALWAYS equals =true
    }
}
