package com.core.lection4.garbage_work_link_types;

import java.lang.ref.*;

/**
 * Created by vlad on 06.02.17.
 */
class A{

}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.gc(); // recommendation to GC to run
        //not recommended to override finalize method

        //Java has 4 types of link :
        /*
        * strong reference
        * soft ref
        * weak reference
        * phantom ref
        *
        * */

        //strong ref
        A pa= new A();//object won't be deleted

        //soft ref
        Reference<A> rs=new SoftReference<>(pa);
        pa=null;
        System.gc();//
        /*if gc decides that memory is enough than object will live ;D*/

        //restore strong ref!
        A pa1=rs.get();

        if(pa1==null){
            pa1=new A();
        }

        //======================    weak ref

        Reference<A> rw = new WeakReference<>(pa1);
        pa1=null;

        System.gc();
        //if object has weak ref than object will be destroyed!


        //=======================   phantom ref
        //used to control objects amount in heap
        A pa3=new A();

        ReferenceQueue rq= new ReferenceQueue();
        Reference<A> rp=new PhantomReference<>(pa3,rq);
        //rp=null;
        pa3=null;
        //if gc see rp on object then object would be destroyed (as weak ref)
        //rp.get();//always NULL

        System.out.println(rq.poll());
        System.gc();
        System.gc();
        Thread.sleep(1000);
        System.out.println(rq.poll());


    }
}
