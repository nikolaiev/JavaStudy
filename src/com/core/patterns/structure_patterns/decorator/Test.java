package com.core.patterns.structure_patterns.decorator;

/**
 * Created by vlad on 15.02.17.
 *
 * Decorator pattern
 */

abstract class Element{
    abstract public void show();
}

class Picture  extends  Element{

    @Override
    public void show() {
        System.out.println("Picture");
    }
}


abstract class Decorator extends Element{
    Element element;

    public Decorator(Element element) {
        this.element = element;
    }
}

class Frame extends Decorator{

    public Frame(Element element) {
        super(element);
    }

    @Override
    public void show() {
        element.show();
        System.out.println("Frame");
    }
}

class Pattern extends Decorator{

    public Pattern(Element element) {
        super(element);
    }

    @Override
    public void show() {
        element.show();
        System.out.println("Pattern");
    }
}


public class Test {
    public static void main(String[] args) {
        Element picture= new Picture();
        Element picturenFrame=new Frame(picture);
        //picturenFrame.show();

        Element pictureInFrameWithPattern = new Pattern(picturenFrame);
        pictureInFrameWithPattern.show();
    }
}
