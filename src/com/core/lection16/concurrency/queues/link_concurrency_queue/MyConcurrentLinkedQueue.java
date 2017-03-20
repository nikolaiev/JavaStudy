package com.core.lection16.concurrency.queues.link_concurrency_queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by vlad on 06.03.17.
 */
public class MyConcurrentLinkedQueue {
    AtomicReference<Node> first=new AtomicReference<>(null);
    AtomicReference<Node> last=new AtomicReference<>(null);
    AtomicInteger size=new AtomicInteger(0);

    private static class Node{
        public int data;
        public Node next;
    }

    public void add(int data){
        Node node=new Node();
        node.data=data;

        while (true){
            Node head=first.get();
            //Node tail=last.get();

            if(head==null){
                if(first.compareAndSet(head,node)){
                    last.set(node);
                    size.incrementAndGet();
                    break;
                }
                else
                    continue;
            }

            node.next=head;

            if(first.compareAndSet(head,node)){
                size.incrementAndGet();
                break;
            }
            else {
                node.next=null;
                continue;
            }


        }
    }

    public Integer remove(){
        while(true){
            Node head=first.get();
            Node tail=last.get();

            if(head==null){
                return null;
            }
            //else

            if(head==tail){
                if(first.compareAndSet(head,null)){
                    last.set(null);
                    size.decrementAndGet();
                    return head.data;
                }
                else continue;
            }
            //else

            Node temp=head;

            while(temp!=null && temp.next!=tail){
                temp=temp.next;
            }

            if(temp==null)
                continue;

            if(last.compareAndSet(temp.next,temp)){
                temp.next=null;
                //tail=null;
                size.decrementAndGet();
                return tail.data;
            }
        }
    }
}
