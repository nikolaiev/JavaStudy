package com.core.patterns.behavior_patterns.visitor;

/**
 * Created by vlad on 20.02.17.
 */

class Acceptor{
    public void accept(Visitor v){
        v.visit(this);
    }
}

interface Visitor{
    void visit(Acceptor a);
}

class MyVisitor implements Visitor{
    public void visit(Acceptor a){
        System.out.println("My visitor!!!");
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Visitor v=new MyVisitor();
        Acceptor a=new Acceptor();
        a.accept(v);
    }
}
