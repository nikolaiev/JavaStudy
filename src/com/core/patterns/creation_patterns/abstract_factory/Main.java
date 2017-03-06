package com.core.patterns.creation_patterns.abstract_factory;



/**
 * Created by vlad on 13.02.17.
 */

enum Factories{
    TRIANGLE_FATORY,CIRCLE_FACTORY
}

class Factory{
    public static GeometryFigureFactory getFactory(Factories factory){
        switch (factory){
            case CIRCLE_FACTORY: return CircleFactory.getInstance();
            case TRIANGLE_FATORY: return TriangleFactory.getInstance();
        }

        return null;
    }
}

/*abstract fabric (is singleton implicity)*/
abstract class GeometryFigureFactory{
    public abstract Shape getShape();
}

/*singleton*/
class TriangleFactory extends GeometryFigureFactory{
    static GeometryFigureFactory instance=new TriangleFactory();
    Shape figure = new Triangle();//de facto - singleton
    public static GeometryFigureFactory getInstance(){
        return instance;
    }

    @Override
    public Shape getShape() {
        return figure;
    }
}

class CircleFactory extends GeometryFigureFactory{
    static GeometryFigureFactory instance=new CircleFactory();

    public static GeometryFigureFactory getInstance(){
        return instance;
    }

    @Override
    public Shape getShape(){
        return new Circle();
    }
}


abstract class Shape{
    public abstract void show();
}

class Triangle extends Shape{
    @Override
    public void show() {
        System.out.println("Triangle");
    }
}

class Circle extends Shape{
    @Override
    public void show() {
        System.out.println("Circle");
    }
}


public class Main {
    public static void main(String[] args) {
        GeometryFigureFactory factory=Factory.getFactory(Factories.CIRCLE_FACTORY);
        Shape product=factory.getShape();
        product.show();
    }
}
